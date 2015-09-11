package za.ac.cput.MotoRental.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MotoRental.Services.RentalService;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.repository.RentalRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@Service
public class RentalImpl implements RentalService {
    @Autowired
    RentalRepository repository;
    public List<Rental> getRental() {
        List<Rental> allRentals = new ArrayList<Rental>();

        Iterable<Rental> rentals = repository.findAll();
        for (Rental rental : rentals) {
            allRentals.add(rental);
        }
        return allRentals;
    }
}
