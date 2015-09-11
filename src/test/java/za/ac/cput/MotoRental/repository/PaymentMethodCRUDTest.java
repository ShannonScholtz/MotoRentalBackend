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
import za.ac.cput.MotoRental.config.factory.PaymentMethodFactory;
import za.ac.cput.MotoRental.domain.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PaymentMethodCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private PaymentMethodRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {

        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Credit", 8000.00);
        repository.save(paymentMethod);

        id = paymentMethod.getId();

        Assert.assertNotNull(paymentMethod.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        PaymentMethod paymentMethod = repository.findOne(id);
        Assert.assertNotNull(paymentMethod);
        Assert.assertEquals("Credit", paymentMethod.getPaymentType());
        Assert.assertEquals(8000.00, paymentMethod.getPrice());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        PaymentMethod paymentMethod = (PaymentMethod)this.repository.findOne(this.id);
        PaymentMethod newPaymentMethod =  new PaymentMethod.Builder(paymentMethod.getPaymentType()).copy(paymentMethod).Price(5000.00).build();
        this.repository.save(newPaymentMethod);
        PaymentMethod updatedPaymentMethod = (PaymentMethod)this.repository.findOne(this.id);
        Assert.assertEquals(5000.00, updatedPaymentMethod.getPrice(), 0.2f);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PaymentMethod paymentMethod = repository.findOne(id);

        repository.delete(paymentMethod);
        PaymentMethod deletedRental = repository.findOne(id);
        Assert.assertNull(deletedRental);

    }
}

