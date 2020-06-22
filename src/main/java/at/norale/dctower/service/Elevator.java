package at.norale.dctower.service;

public interface Elevator {
  public int getId();

  public int getCurrentFloor();

  public void setCurrentFloor(int currentFloor);

  public void travelTo(int destinationFloor);
}
