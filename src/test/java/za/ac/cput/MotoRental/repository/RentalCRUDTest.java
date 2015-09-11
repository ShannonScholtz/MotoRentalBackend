package za.ac.cput.MotoRental.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.MotoRental.App;
import za.ac.cput.MotoRental.config.factory.RentalFactory;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RentalCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private RentalRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        List<PaymentMethod> paymentMethods = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = RentalFactory.createRental("22-07-2015", "28-07-2015", paymentMethods);

        repository.save(rental);

        id = rental.getId();

        Assert.assertNotNull(rental.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        Rental rental = repository.findOne(id);
        Assert.assertNotNull(rental);
        Assert.assertEquals("22-07-2015", rental.getPickUpDate());
        Assert.assertEquals("28-07-2015", rental.getReturnDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Rental rental = (Rental)this.repository.findOne(this.id);
        Rental newRental =  new Rental.Builder(rental.getPickUpDate()).copy(rental).returnDate("27-08-2015").build();
        this.repository.save(newRental);
        Rental updatedRental = (Rental)this.repository.findOne(this.id);
        Assert.assertEquals("27-08-2015", updatedRental.getReturnDate());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Rental rental = repository.findOne(id);

        repository.delete(rental);
        Rental deletedRental = repository.findOne(id);
        Assert.assertNull(deletedRental);

    }
}
