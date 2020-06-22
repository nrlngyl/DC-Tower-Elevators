package at.norale.dctower.service;

import at.norale.dctower.exceptions.ServiceException;
import at.norale.dctower.exceptions.ValidationException;

import java.util.List;

public interface ControlPlane {

  String transport(int currentFloor, int destinationFloor) throws ServiceException;

  List<String> printState();
}
