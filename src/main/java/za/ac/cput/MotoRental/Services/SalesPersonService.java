package za.ac.cput.MotoRental.Services;

import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.SalesPerson;

import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
public interface SalesPersonService  extends Services<SalesPerson,Long>{
    //List<SalesPerson> getSalesPerson();
    List<Customer> getCustomers(Long id);


}
