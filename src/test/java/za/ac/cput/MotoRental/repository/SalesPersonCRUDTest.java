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
import za.ac.cput.MotoRental.config.factory.AddressEmbeddableFactory;
import za.ac.cput.MotoRental.config.factory.CustomerFactory;
import za.ac.cput.MotoRental.config.factory.LoginEmbeddableFactory;
import za.ac.cput.MotoRental.config.factory.SalesPersonFactory;
import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.domain.SalesPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SalesPersonCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private SalesPersonRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {

        SalesPerson salesPerson= SalesPersonFactory.createSalesPerson("Peter", "John", 8, 200.00 , "pjohn", "pj100K", null);

        repository.save(salesPerson);

        id = salesPerson.getId();

        Assert.assertNotNull(salesPerson.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        SalesPerson salesPerson = repository.findOne(id);
        Assert.assertNotNull(salesPerson);
        Assert.assertEquals("Peter", salesPerson.getFirstName());
        Assert.assertEquals("John", salesPerson.getLastName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        SalesPerson salesPerson = (SalesPerson)this.repository.findOne(this.id);
        SalesPerson newsalesPerson =  new SalesPerson.Builder(salesPerson.getLastName()).copy(salesPerson).rate(250.00).build();
        this.repository.save(newsalesPerson);
        SalesPerson updatedsalesPerson = (SalesPerson)this.repository.findOne(this.id);
        Assert.assertEquals(250.00, updatedsalesPerson.getRate());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        SalesPerson salesPerson = repository.findOne(id);

        repository.delete(salesPerson);
        SalesPerson deletedSalesPerson = repository.findOne(id);
        Assert.assertNull(deletedSalesPerson);

    }
}
