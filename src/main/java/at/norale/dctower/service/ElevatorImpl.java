package at.norale.dctower.service;

public class ElevatorImpl implements Elevator {

  private int id;
  private int currentFloor;

  public ElevatorImpl(int id) {
    this.currentFloor = 0;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  @Override
  public void travelTo(int destinationFloor) {
    currentFloor = destinationFloor;
  }
}
