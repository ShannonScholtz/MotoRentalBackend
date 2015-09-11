package za.ac.cput.MotoRental.Services;

import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
public interface CustomerService extends Services<Customer,Long> {
    //List<Customer> getCustomer();
    List<Rental> getRental(Long id);
}
