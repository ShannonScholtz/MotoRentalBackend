package za.ac.cput.MotoRental.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MotoRental.config.factory.PaymentMethodFactory;

/**
 * Created by student on 2015/08/19.
 */
public class PaymentMethodTest {

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Credit", 200.00);
        Assert.assertEquals(200.00, paymentMethod.getPrice(), 0.2f);
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Debit", 200.00);

        PaymentMethod newPaymentMethod = new PaymentMethod.Builder(paymentMethod.getPaymentType())
                .copy(paymentMethod)
                .Price(800.00)
                .build();

        Assert.assertEquals(200.00, paymentMethod.getPrice(), 0.2f);
        Assert.assertEquals(800.00,newPaymentMethod.getPrice(), 0.2f);
    }
}

