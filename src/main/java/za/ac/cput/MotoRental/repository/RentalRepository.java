package za.ac.cput.MotoRental.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MotoRental.domain.Rental;

/**
 * Created by student on 2015/08/12.
 */
public interface RentalRepository extends CrudRepository<Rental, Long> {
}