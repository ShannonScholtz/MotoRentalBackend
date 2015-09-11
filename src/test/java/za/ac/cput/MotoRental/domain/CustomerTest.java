package za.ac.cput.MotoRental.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MotoRental.config.factory.CustomerFactory;

/**
 * Created by student on 2015/08/19.
 */
public class CustomerTest {
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        Customer customer = CustomerFactory.createCustomer("Jackson", "Peters", "0821298252", "9 jack way Durbanville", "Cape Town", "7734", "sscholtz", "ssCHoltz1", null);
        Assert.assertEquals("Jackson", customer.getFirstName());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        Customer customer = CustomerFactory.createCustomer("Jackson", "Peters", "0821298252", "9 jack way Durbanville", "Cape Town", "7734", "sscholtz", "ssCHoltz1", null);

        Customer newCustomer = new Customer.Builder(customer.getLastName())
                .copy(customer)
                .phoneNumber("0841298555")
                .build();

        Assert.assertEquals("0821298252", customer.getPhoneNumber());
        Assert.assertEquals("0841298555", newCustomer.getPhoneNumber());
    }
}
