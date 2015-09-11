package za.ac.cput.MotoRental.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MotoRental.Services.SalesPersonService;
import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.Rental;
import za.ac.cput.MotoRental.domain.SalesPerson;
import za.ac.cput.MotoRental.repository.SalesPersonRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@Service
public class SalesPersonImpl implements SalesPersonService {
    @Autowired
    private SalesPersonRepository repository;

    @Override
    public SalesPerson findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public SalesPerson save(SalesPerson entity) {
        return repository.save(entity);
    }

    @Override
    public SalesPerson update(SalesPerson entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(SalesPerson entity) {
        repository.delete(entity);

    }

    @Override
    public List<SalesPerson> findAll() {
        List<SalesPerson> allSalesPersons = new ArrayList();
        Iterable<SalesPerson> salesPersons = repository.findAll();
        for (SalesPerson salesPerson : salesPersons) {
            allSalesPersons.add(salesPerson);
        }
        return allSalesPersons;
    }

    @Override
    public List<Customer> getCustomers(Long id)
    {
        return repository.findOne(id).getCustomers();
    }

}



















/*@Service
public class SalesPersonImpl implements SalesPersonService {
    @Autowired
    SalesPersonRepository repository;
    public List<SalesPerson> getSalesPerson() {
        List<SalesPerson> allSalesPersons = new ArrayList<SalesPerson>();

        Iterable<SalesPerson> salesPersons = repository.findAll();
        for (SalesPerson salesPerson : salesPersons) {
            allSalesPersons.add(salesPerson);
        }
        return allSalesPersons;
    }

    @Override
    public List<Customer> getCustomers(Long id)
    {
        return repository.findOne(id).getCustomers();
    }
}*/