package za.ac.cput.MotoRental.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MotoRental.domain.MotorCycle;

/**
 * Created by student on 2015/08/13.
 */
public interface MotorCycleRepository extends CrudRepository<MotorCycle, Long> {
}
