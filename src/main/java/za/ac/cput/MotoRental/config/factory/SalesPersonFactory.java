package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.domain.SalesPerson;

import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
public class SalesPersonFactory {


    public static SalesPerson createSalesPerson(String firstName, String lastName, int hours, double rate, String username, String password, List<Customer> customers)
    {
        SalesPerson salesPerson = new SalesPerson
                .Builder(lastName)
                .firstName(firstName)
                .hours(hours)
                .rate(rate)
                .customers(customers)
                .build();
        return salesPerson;
    }
}