package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.AddressEmbeddable;

/**
 * Created by student on 2015/08/12.
 */
public class AddressEmbeddableFactory {
    public static AddressEmbeddable createAddress(String Address, String City, String postalCode)
    {
        AddressEmbeddable addressEmbeddable = new AddressEmbeddable
                .Builder(Address)
                .City(City)
                .postalCode(postalCode)
                .build();

        return addressEmbeddable;
    }
}

