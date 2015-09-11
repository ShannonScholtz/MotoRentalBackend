package za.ac.cput.MotoRental.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MotoRental.Services.PaymentMethodService;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.repository.PaymentMethodRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@Service
public class PaymentMethodImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodRepository repository;
    public List<PaymentMethod> getPaymentMethod() {
        List<PaymentMethod> allPaymentMethods = new ArrayList<PaymentMethod>();

        Iterable<PaymentMethod> paymentMethods = repository.findAll();
        for (PaymentMethod paymentMethod : paymentMethods) {
            allPaymentMethods.add(paymentMethod);
        }
        return allPaymentMethods;
    }
}
