package za.ac.cput.MotoRental.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MotoRental.config.factory.RentalFactory;

/**
 * Created by student on 2015/08/19.
 */
public class RentalTest {

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        Rental rental = RentalFactory.createRental("22-07-2015", "28-07-2015", null);

        Assert.assertEquals("28-07-2015", rental.getReturnDate());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        Rental rental = RentalFactory.createRental("22-07-2015", "28-07-2015", null);

        Rental newRental = new Rental.Builder(rental.getPickUpDate())
                .copy(rental)
                .returnDate("30-07-2015")
                .build();

        Assert.assertEquals("28-07-2015", rental.getReturnDate());
        Assert.assertEquals("30-07-2015", newRental.getReturnDate());
    }
}

