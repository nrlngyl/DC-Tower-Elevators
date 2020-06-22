package at.norale.dctower.validators;

import at.norale.dctower.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FloorValidator {

  private static final Logger LOGGER = LoggerFactory.getLogger(FloorValidator.class);

  public void validator(int startingFloor, int destinationFloor, int lowestFloor, int highestFloor)
      throws ValidationException {

    LOGGER.info(
        "Validating inputs: current floor = "
            + startingFloor
            + ", destination floor = "
            + destinationFloor);

    if (startingFloor > highestFloor || destinationFloor > highestFloor) {
      LOGGER.error("Floor number does not exist.");
      throw new ValidationException("The floor number can not exceed 55.");
    }

    if (startingFloor < lowestFloor || destinationFloor < lowestFloor) {
      LOGGER.error("Floor number does not exist.");
      throw new ValidationException("The floor number cannot be lower than 0.");
    }
  }
}
