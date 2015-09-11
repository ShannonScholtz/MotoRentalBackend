package za.ac.cput.MotoRental.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@Entity
public class SalesPerson implements Person, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="salesperson_id")
    private List<Customer> customers;

    //constructors
    private SalesPerson()
    {

    }

    public SalesPerson(Builder builder)
    {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours= builder.hours;
        this.rate=builder.rate;
        this.customers=builder.customers;
    }


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

    public int getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    //getters



    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private List<Customer> customers;

        public Builder(String lastName)
        {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder hours(int hours)
        {
            this.hours = hours;
            return this;
        }

        public Builder rate(double rate)
        {
            this.rate = rate;
            return this;
        }


        public Builder customers(List<Customer> customers)
        {
            this.customers = customers;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(SalesPerson salesperson)
        {
            this.id = salesperson.id;
            this.firstName = salesperson.firstName;
            this.lastName = salesperson.lastName;
            this.hours = salesperson.hours;
            this.rate = salesperson.rate;
            this.customers = salesperson.customers;

            return this;
        }

        public SalesPerson build()
        {
            return new SalesPerson(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SalesPerson salesperson = (SalesPerson) o;

        return id.equals(salesperson.id);
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
