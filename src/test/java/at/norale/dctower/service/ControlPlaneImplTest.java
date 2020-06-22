package at.norale.dctower.service;

import at.norale.dctower.exceptions.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Provider;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControlPlaneImplTest {

  @Autowired ControlPlaneImpl controlPlane;

  @Test
  public void alwaysClosestElevatorIsCalled() throws ServiceException {
    controlPlane.transport(0, 15);
    controlPlane.transport(16, 17);
    Elevator zeroElevator = controlPlane.getElevators().get(0);
    assertEquals(zeroElevator.getCurrentFloor(), 17);
  }

  @Test
  public void getAllElevatorsAreAllElevators() {
    List<Elevator> elevators = controlPlane.getElevators();
    assertEquals(elevators.size(), controlPlane.getNumberOfElevators());
  }

  @Test
  public void ifInvalidFloorNumberThrowsException_ServiceExceptionThrown() {

    Exception exception =
        assertThrows(
            ServiceException.class,
            () -> {
              controlPlane.transport(-1, 0);
            });

    String expectedMessage = "The floor number cannot be lower than 0.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
