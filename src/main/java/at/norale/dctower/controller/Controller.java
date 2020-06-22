package at.norale.dctower.controller;

import at.norale.dctower.Validators.FloorValidator;
import at.norale.dctower.exceptions.ServiceException;
import at.norale.dctower.exceptions.ValidationException;
import at.norale.dctower.service.ControlPlane;
import at.norale.dctower.service.Elevator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

  private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

  private ControlPlane controlPlane;

  public Controller(ControlPlane controlPlane) {
    this.controlPlane = controlPlane;
  }

  @RequestMapping(
      value = "/transport/{startingFloor}/{destinationFloor}",
      method = RequestMethod.PUT)
  public String transport(@PathVariable int startingFloor, @PathVariable int destinationFloor) {
    LOGGER.info(
        "GET /transport to from floor #" + startingFloor + "  to floor #" + destinationFloor);

    try {
      return controlPlane.transport(startingFloor, destinationFloor);
    } catch (ServiceException se) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Error in transport command: " + se.getMessage());
    }
  }

  @RequestMapping(value = "/getState", method = RequestMethod.GET)
  public List<String> getState() {
    return controlPlane.printState();
  }
}
