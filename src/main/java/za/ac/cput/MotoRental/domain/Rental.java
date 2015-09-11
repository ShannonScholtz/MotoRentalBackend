package za.ac.cput.MotoRental.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@Entity
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pickUpDate;
    private String returnDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id")
    private List<PaymentMethod> paymentMethod;

    private Rental() {

    }

    public Rental(Builder builder) {
        this.id = builder.id;
        this.pickUpDate = builder.pickUpDate;
        this.returnDate = builder.returnDate;
        this.paymentMethod = builder.paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public List<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }


    public static class Builder {
        private Long id;
        private String pickUpDate;
        private String returnDate;
        private List<PaymentMethod> paymentMethod;


        public Builder(String pickUpDate) {
            this.pickUpDate = pickUpDate;
        }

        public Builder returnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder paymentMethod(List<PaymentMethod> paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(Rental rental) {
            this.id = rental.id;
            this.pickUpDate = rental.pickUpDate;
            this.returnDate = rental.returnDate;
            this.paymentMethod = rental.paymentMethod;

            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        return id.equals(rental.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Pick Up Date: " + pickUpDate + "" + "Return Date: " + returnDate;
    }
}
