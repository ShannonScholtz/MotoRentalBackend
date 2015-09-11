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
import za.ac.cput.MotoRental.config.factory.CustomerFactory;
import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private CustomerRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-07-2015").returnDate("28-07-2015").paymentMethod(paymentMethods).build();
        rentals.add(rental);


        Customer customer = CustomerFactory.createCustomer("Shannon", "Scholtz", "0821234252", "5 peter way Durbanville", "Cape Town", "7734", "sscholtz", "ssCHoltz1", rentals);

        repository.save(customer);

        id = customer.getId();

        Assert.assertNotNull(customer.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        Customer customer = repository.findOne(id);
        Assert.assertNotNull(customer);
        Assert.assertEquals("Shannon", customer.getFirstName());
        Assert.assertEquals("Scholtz", customer.getLastName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Customer customer = (Customer)this.repository.findOne(this.id);
        Customer newCustomer =  new Customer.Builder(customer.getLastName()).copy(customer).firstName("Kelly").build();
        this.repository.save(newCustomer);
        Customer updatedCustomer = (Customer)this.repository.findOne(this.id);
        Assert.assertEquals("Kelly", updatedCustomer.getFirstName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer customer = repository.findOne(id);

        repository.delete(customer);
        Customer deletedCustomer = repository.findOne(id);
        Assert.assertNull(deletedCustomer);

    }
}
