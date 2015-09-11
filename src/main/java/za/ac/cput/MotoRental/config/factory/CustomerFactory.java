package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
public class CustomerFactory {


    public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String Address, String City, String postalCode, String username, String password, List<Rental> rentals)
    {
        Customer customer = new Customer
                .Builder(lastName)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .addressEmbeddable(AddressEmbeddableFactory.createAddress(Address, City, postalCode))
                .loginEmbeddable(LoginEmbeddableFactory.createLogin(username, password))
                .rentals(rentals)
                .build();
        return customer;
    }
}
