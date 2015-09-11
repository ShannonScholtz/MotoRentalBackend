package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
public class RentalFactory {


    public static Rental createRental(String pickUpdate, String returnDate,  List<PaymentMethod> paymentMethod)
    {
        Rental rental = new Rental
                .Builder(pickUpdate)
                .returnDate(returnDate)
                .paymentMethod(paymentMethod)
                .build();
        return rental;
    }
}
