package za.ac.cput.MotoRental.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MotoRental.domain.EngineTypeEmbeddable;
import za.ac.cput.MotoRental.domain.MotorBikeConditionEmbeddable;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
public class MotorCycleResources extends ResourceSupport {

    private Long resid;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String year;
    private MotorBikeConditionEmbeddable motorBikeConditionEmbeddable;
    private EngineTypeEmbeddable engineTypeEmbeddable;
    private List<Rental> rentals;

    private MotorCycleResources() {

    }

    public MotorCycleResources(Builder builder) {
        this.resid = builder.id;
        this.SerialNumber = builder.SerialNumber;
        this.Make = builder.Make;
        this.Model = builder.Model;
        this.year = builder.year;
        this.motorBikeConditionEmbeddable = builder.motorBikeConditionEmbeddable;
        this.engineTypeEmbeddable = builder.engineTypeEmbeddable;
        this.rentals = builder.rentals;
    }

    public Long getResid() {
        return resid;
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

        public Builder copy(MotorCycleResources motorCycle) {
            this.id = motorCycle.resid;
            this.SerialNumber = motorCycle.SerialNumber;
            this.Make = motorCycle.Make;
            this.Model = motorCycle.Model;
            this.year = motorCycle.year;
            this.motorBikeConditionEmbeddable = motorCycle.motorBikeConditionEmbeddable;
            this.engineTypeEmbeddable = motorCycle.engineTypeEmbeddable;
            this.rentals = motorCycle.rentals;
            return this;
        }

        public MotorCycleResources build() {
            return new MotorCycleResources(this);
        }
    }
}

