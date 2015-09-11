package za.ac.cput.MotoRental.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MotoRental.domain.Customer;

/**
 * Created by student on 2015/08/12.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
