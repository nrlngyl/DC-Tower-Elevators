package at.norale.dctower.service;

import at.norale.dctower.validators.FloorValidator;
import at.norale.dctower.exceptions.ServiceException;
import at.norale.dctower.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControlPlaneImpl implements ControlPlane {

  private static final Logger LOGGER = LoggerFactory.getLogger(ControlPlane.class);

  private static final int NUMBER_OF_ELEVATORS = 7;
  private static final int LOWEST_FLOOR = 0;
  private static final int HIGHEST_FLOOR = 55;

  private final List<Elevator> elevators;
  private FloorValidator floorValidator;

  public ControlPlaneImpl(FloorValidator floorValidator) {
    this.elevators = new ArrayList<>();
    for (int i = 0; i < NUMBER_OF_ELEVATORS; i++) {
      this.elevators.add(new ElevatorImpl(i));
    }
    this.floorValidator = floorValidator;
  }

  @Override
  public String transport(int startingFloor, int destinationFloor) throws ServiceException {
    LOGGER.info(
        "Transport elevator from floor #" + startingFloor + " to floor #" + destinationFloor);

    String feedback;

    try {
      floorValidator.validator(startingFloor, destinationFloor, LOWEST_FLOOR, HIGHEST_FLOOR);

    } catch (ValidationException ve) {
      throw new ServiceException(ve.getMessage(), ve);
    }

    if (elevators.size() > 0) {
      Elevator nearestElevator = elevators.get(0);

      int nearestDistance = 55;
      for (Elevator elevator : elevators) {
        int distance = Math.abs(startingFloor - elevator.getCurrentFloor());
        if (distance < nearestDistance) {
          nearestDistance = distance;
          nearestElevator = elevator;
        }
      }
      nearestElevator.setCurrentFloor(destinationFloor);
      feedback = "Elevator " + nearestElevator.getId() + " moved to " + destinationFloor;
      LOGGER.info(feedback);
    } else {
      feedback = "There are no elevators in the system.";
      LOGGER.error(feedback);
    }
    return feedback;
  }

  @Override
  public List<String> printState() {
    List<String> state = new ArrayList<>();
    elevators.forEach(
        elevator -> {
          String stateMessage =
              "Elevator " + elevator.getId() + " is on floor #" + elevator.getCurrentFloor();
          System.out.println(stateMessage);
          state.add(stateMessage);
        });
    return state;
  }

  @Override
  public List<Elevator> getElevators() {
    return elevators;
  }

  @Override
  public int getNumberOfElevators() {
    return NUMBER_OF_ELEVATORS;
  }
}
