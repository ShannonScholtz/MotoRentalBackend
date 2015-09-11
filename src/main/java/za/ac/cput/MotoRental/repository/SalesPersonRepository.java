package za.ac.cput.MotoRental.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MotoRental.domain.SalesPerson;

/**
 * Created by student on 2015/08/13.
 */
public interface SalesPersonRepository extends CrudRepository<SalesPerson, Long> {
}