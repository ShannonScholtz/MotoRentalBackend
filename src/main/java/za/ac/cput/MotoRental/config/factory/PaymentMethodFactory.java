package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.PaymentMethod;

/**
 * Created by student on 2015/08/12.
 */
public class PaymentMethodFactory {


    public static PaymentMethod createPaymentMethod(String PaymentType, double Price)
    {
        PaymentMethod paymentMethod = new PaymentMethod
                .Builder(PaymentType)
                .Price(Price)
                .build();
        return paymentMethod;
    }
}