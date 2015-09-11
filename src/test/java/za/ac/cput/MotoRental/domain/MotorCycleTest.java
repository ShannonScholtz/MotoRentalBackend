package za.ac.cput.MotoRental.domain;

import org.junit.Assert;
import org.junit.Before;


import org.junit.Test;
import za.ac.cput.MotoRental.config.factory.MotorCycleFactory;

/**
 * Created by student on 2015/08/19.
 */
public class MotorCycleTest {

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        MotorCycle motorCycle = MotorCycleFactory.createMotorCycle("HON34AA", "Honda", "CBR", "2006", "2000km", "full", "Mint ", "600ccsd", "600cc", "Unleaded ", null);

        Assert.assertEquals("Honda", motorCycle.getMake());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        MotorCycle motorCycle = MotorCycleFactory.createMotorCycle("HON3AA", "Honda", "CBR", "2006", "2000km", "full", "Mint ", "600ccsd", "600cc", "Unleaded ", null);

        MotorCycle newMotorCycle = new MotorCycle.Builder(motorCycle.getSerialNumber())
                .copy(motorCycle)
                .Model("VFR")
                .build();

        Assert.assertEquals("CBR", motorCycle.getModel());
        Assert.assertEquals("VFR", newMotorCycle.getModel());
    }
}
