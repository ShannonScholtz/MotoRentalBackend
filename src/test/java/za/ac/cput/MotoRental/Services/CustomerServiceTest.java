package za.ac.cput.MotoRental.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.MotoRental.App;
import za.ac.cput.MotoRental.config.factory.CustomerFactory;
import za.ac.cput.MotoRental.config.factory.RentalFactory;
import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private CustomerService service;

    @Test
    public void create() throws Exception {
        //Create a Customer Class


        List<PaymentMethod> paymentMethods1 = new ArrayList();
        List<Rental> rental = new ArrayList();

        PaymentMethod paymentMethod1 = new PaymentMethod.Builder("Credit").Price(400.00).build();
        paymentMethods1.add(paymentMethod1);


        Rental rental1 = RentalFactory.createRental("11/05/2015", "12-05-2015", paymentMethods1);
        rental.add(rental1);


        Customer customer= CustomerFactory
                .createCustomer("Jabaar", "Faizel", "0843024829", "5 Gimpie street Woodstock", "Cape Town", "8001", "fjabaar", "passfj", rental);
        // Save in the Database
        service.save(customer);
        //Id Should be available
        id = customer.getId();
        Assert.assertNotNull(customer);

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get Customer
        Customer customer = service.findById(id);
        Assert.assertEquals("Jabaar", customer.getFirstName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        //Get Customer
        Customer customer = service.findById(id);
        //Change it
        Customer newCustomer = new Customer
                .Builder(customer.getLastName())
                .copy(customer)
                .firstName("Riyaaz").build();
        //Save it
        service.update(newCustomer);
        //Get Updated Customer
        Customer updatedCustomer = service.findById(id);
        Assert.assertEquals("Riyaaz", updatedCustomer.getFirstName());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer customer = service.findById(id);
        service.delete(customer);
        Customer deletedCustomer = service.findById(id);
        Assert.assertNull(deletedCustomer);
    }
}


