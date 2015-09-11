package za.ac.cput.MotoRental.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MotoRental.domain.AddressEmbeddable;
import za.ac.cput.MotoRental.domain.LoginEmbeddable;
import za.ac.cput.MotoRental.domain.Person;
import za.ac.cput.MotoRental.domain.Rental;

import javax.persistence.*;
import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
public class CustomerResource extends ResourceSupport implements Person {

    private Long resid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Embedded
    private AddressEmbeddable addressEmbeddable;
    @Embedded
    private LoginEmbeddable loginEmbeddable;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Rental> rentals;

    //constructors
    private CustomerResource()
    {

    }

    public CustomerResource(Builder builder)
    {
        this.resid = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.addressEmbeddable = builder.addressEmbeddable;
        this.loginEmbeddable = builder.loginEmbeddable;
        this.rentals = builder.rentals;
    }

    //getters


    public Long getResid() {
        return resid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressEmbeddable getAddressEmbeddable() {
        return addressEmbeddable;
    }

    public LoginEmbeddable getLoginEmbeddable() {
        return loginEmbeddable;
    }

    public List<Rental> getRentals() {
        return rentals;
    }


    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private AddressEmbeddable addressEmbeddable;
        private LoginEmbeddable loginEmbeddable;
        private List<Rental> rentals;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder addressEmbeddable(AddressEmbeddable addressEmbeddable) {
            this.addressEmbeddable = addressEmbeddable;
            return this;
        }

        public Builder loginEmbeddable(LoginEmbeddable loginEmbeddable) {
            this.loginEmbeddable = loginEmbeddable;
            return this;
        }

        public Builder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource customer)
        {
            this.id = customer.resid;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.addressEmbeddable = customer.addressEmbeddable;
            this.loginEmbeddable = customer.loginEmbeddable;
            this.rentals = customer.rentals;
            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }
}
