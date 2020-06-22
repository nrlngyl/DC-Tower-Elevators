package at.norale.dctower.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ControlPlaneImplTest {

    @Autowired
    ControlPlaneImpl controlPlane;

   /* @Test
    public void testAlwaysClosestElevatorIsCalled(){
        controlPlane.transport(0,15);
        controlPlane.transport(16,17);
        Elevator zeroElevator = controlPlane.getElevators().get(0);
        assertEquals(zeroElevator.getCurrentFloor(), 17);
    }*/
}
