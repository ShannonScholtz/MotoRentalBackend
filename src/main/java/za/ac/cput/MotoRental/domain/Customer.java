package za.ac.cput.MotoRental.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@Entity
public class Customer implements Person, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private Customer()
    {

    }

    public Customer(Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.addressEmbeddable = builder.addressEmbeddable;
        this.loginEmbeddable = builder.loginEmbeddable;
        this.rentals = builder.rentals;
    }

    //getters
    public Long getId() {
        return id;
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

        public Builder copy(Customer customer)
        {
            this.id = customer.id;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.addressEmbeddable = customer.addressEmbeddable;
            this.loginEmbeddable = customer.loginEmbeddable;
            this.rentals = customer.rentals;
            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id.equals(customer.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + "" + "Surname: " + lastName;
    }
}
