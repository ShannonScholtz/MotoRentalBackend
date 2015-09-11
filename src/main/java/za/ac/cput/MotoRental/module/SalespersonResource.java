package za.ac.cput.MotoRental.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MotoRental.domain.Customer;
import za.ac.cput.MotoRental.domain.Person;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
public class SalespersonResource extends ResourceSupport implements Person {

    private Long resid;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="salesperson_id")
    private List<Customer> customers;

    //constructors
    private SalespersonResource()
    {

    }

    public SalespersonResource(Builder builder)
    {
        this.resid=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours= builder.hours;
        this.rate=builder.rate;
        this.customers=builder.customers;
    }


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

        public Builder copy(SalespersonResource salesperson)
        {
            this.id = salesperson.resid;
            this.firstName = salesperson.firstName;
            this.lastName = salesperson.lastName;
            this.hours = salesperson.hours;
            this.rate = salesperson.rate;
            this.customers = salesperson.customers;

            return this;
        }

        public SalespersonResource build()
        {
            return new SalespersonResource(this);
        }
    }
}
