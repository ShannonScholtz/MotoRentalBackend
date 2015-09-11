package za.ac.cput.MotoRental.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.MotoRental.App;
import za.ac.cput.MotoRental.config.factory.MotorCycleFactory;
import za.ac.cput.MotoRental.config.factory.RentalFactory;
import za.ac.cput.MotoRental.domain.MotorCycle;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.repository.MotorCycleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class MotorCycleServiceTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private MotorCycleService service;

    @Test
    public void create() throws Exception {
        //Create a MotorCycle Class


        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-07-2015").returnDate("28-07-2015").paymentMethod(paymentMethods).build();
        rentals.add(rental);

        MotorCycle motorCycle = MotorCycleFactory
                .createMotorCycle("HondCB2424", "Honda", "Cbr", "2006", "200km", "Half Tank", "Mint ", "1000cccbr", "600cc", "Unleaded ", rentals);
        // Save in the Database
        service.save(motorCycle);
        //Id Should be available
        id = motorCycle.getId();
        Assert.assertNotNull(motorCycle);

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        MotorCycle motorCycle = service.findById(id);
        Assert.assertEquals("2006", motorCycle.getYear());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        //Get MotorCycle
        MotorCycle motorCycle = service.findById(id);
        //Change it
        MotorCycle newMotorCycle = new MotorCycle
                .Builder(motorCycle.getSerialNumber())
                .copy(motorCycle)
                .year("2010").build();
        //Save it
        service.update(newMotorCycle);
        //Get Updated MotorCycle
        MotorCycle updatedMotorCycle = service.findById(id);
        Assert.assertEquals("2010", updatedMotorCycle.getYear());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        MotorCycle motorCycle = service.findById(id);
        service.delete(motorCycle);
        MotorCycle deletedMotorCycle = service.findById(id);
        Assert.assertNull(deletedMotorCycle);
    }
}