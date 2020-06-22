package at.norale.dctower.service;

import at.norale.dctower.exceptions.ServiceException;

import java.util.List;

public interface ControlPlane {

  /**
   * @param startingFloor the floor from which the elevator is called
   * @param destinationFloor the floor where the elevator is supposed to go
   * @return returns a string message with an update
   * @throws ServiceException
   */
  String transport(int startingFloor, int destinationFloor) throws ServiceException;

  /** @return gets current state of all elevators, in a form of a list of string. */
  List<String> printState();

  List<Elevator> getElevators();

  int getNumberOfElevators();
}
