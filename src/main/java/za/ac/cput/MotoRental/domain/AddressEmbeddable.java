package za.ac.cput.MotoRental.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/12.
 */
@Embeddable
public class AddressEmbeddable implements Serializable {

    private String Address;
    private String City;
    private String postalCode;

    //constructors
    private AddressEmbeddable()
    {

    }

    public AddressEmbeddable(Builder builder)
    {
        this.Address = builder.Address;
        this.City = builder.City;
        this.postalCode = builder.postalCode;
    }

    //getters
    public String getAddress()
    {
        return Address;
    }

    public String getCity()
    {
        return City;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder
    {
        private String Address;
        private String City;
        private String postalCode;

        public Builder(String Address)
        {
            this.Address = Address;
        }

        public Builder City(String City)
        {
            this.City = City;
            return this;
        }

        public Builder postalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(AddressEmbeddable addressEmbeddable)
        {
            this.Address = addressEmbeddable.Address;
            this.City = addressEmbeddable.City;
            this.postalCode = addressEmbeddable.postalCode;
            return this;
        }

        public AddressEmbeddable build()
        {
            return new AddressEmbeddable(this);
        }
    }
}