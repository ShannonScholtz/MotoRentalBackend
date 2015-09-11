package za.ac.cput.MotoRental.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/13.
 */
@Entity
public class MotorCycle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String year;
    @Embedded
    private MotorBikeConditionEmbeddable motorBikeConditionEmbeddable;
    @Embedded
    private EngineTypeEmbeddable engineTypeEmbeddable;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "motorcycle_id")
    private List<Rental> rentals;

    private MotorCycle() {

    }

    public MotorCycle(Builder builder) {
        this.id = builder.id;
        this.SerialNumber = builder.SerialNumber;
        this.Make = builder.Make;
        this.Model = builder.Model;
        this.year = builder.year;
      this.motorBikeConditionEmbeddable = builder.motorBikeConditionEmbeddable;
         this.engineTypeEmbeddable = builder.engineTypeEmbeddable;
        this.rentals = builder.rentals;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getYear() {
        return year;
    }

    public MotorBikeConditionEmbeddable getMotorBikeConditionEmbeddable() {
        return motorBikeConditionEmbeddable;
    }

    public EngineTypeEmbeddable getEngineTypeEmbeddable() {
        return engineTypeEmbeddable;
    }

    public List<Rental> getRentals() {
        return rentals;
    }


    public static class Builder {
        private Long id;
        private String SerialNumber;
        private String Make;
        private String Model;
        private String year;
        private MotorBikeConditionEmbeddable motorBikeConditionEmbeddable;
     // private MotorCycleStatusEmbeddable motorCycleStatusEmbeddable;
       private EngineTypeEmbeddable engineTypeEmbeddable;
        private List<Rental> rentals;

        public Builder(String SerialNumber) {
            this.SerialNumber = SerialNumber;
        }

        public Builder Make(String Make) {
            this.Make = Make;
            return this;
        }

        public Builder Model(String Model) {
            this.Model = Model;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder motorBikeCondition(MotorBikeConditionEmbeddable motorBikeConditionEmbeddable) {
            this.motorBikeConditionEmbeddable = motorBikeConditionEmbeddable;
            return this;
        }

        public Builder engineTypeEmbeddable(EngineTypeEmbeddable engineTypeEmbeddable) {
            this.engineTypeEmbeddable = engineTypeEmbeddable;
            return this;
        }

        public Builder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }

        public Builder copy(MotorCycle motorCycle) {
            this.id = motorCycle.id;
            this.SerialNumber = motorCycle.SerialNumber;
            this.Make = motorCycle.Make;
            this.Model = motorCycle.Model;
            this.year = motorCycle.year;
            this.motorBikeConditionEmbeddable = motorCycle.motorBikeConditionEmbeddable;
            this.engineTypeEmbeddable = motorCycle.engineTypeEmbeddable;
            this.rentals = motorCycle.rentals;
            return this;
        }

        public MotorCycle build() {
            return new MotorCycle(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MotorCycle motorCycle = (MotorCycle) o;

        return id.equals(motorCycle.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Make: " + Make;
    }
}
