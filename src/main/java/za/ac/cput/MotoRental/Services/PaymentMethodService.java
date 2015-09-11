package za.ac.cput.MotoRental.Services;

import za.ac.cput.MotoRental.domain.PaymentMethod;

import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
public interface PaymentMethodService {
    List<PaymentMethod> getPaymentMethod();
}
