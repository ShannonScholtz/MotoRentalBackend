package za.ac.cput.MotoRental.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/19.
 */
@Embeddable
public class MotorBikeCondition implements Serializable {

    private String OdometreReading;
    private String Gas;
    private String BikeCondition;

    //constructors
    private MotorBikeCondition()
    {

    }

    public MotorBikeCondition(Builder builder)
    {
        this.OdometreReading = builder.OdometreReading;
        this.Gas = builder.Gas;
        this.BikeCondition = builder.BikeCondition;
    }

    //getters
    public String getOdometreReading() {
        return OdometreReading;
    }

    public String getGas() {
        return Gas;
    }

    public String getBikeCondition() {
        return BikeCondition;
    }

    public static class Builder
    {
        private String OdometreReading;
        private String Gas;
        private String BikeCondition;

        public Builder(String OdometreReading)
        {
            this.OdometreReading = OdometreReading;
        }

        public Builder Gas(String Gas)
        {
            this.Gas = Gas;
            return this;
        }

        public Builder BikeCondition(String BikeCondition)
        {
            this.BikeCondition = BikeCondition;
            return this;
        }

        public Builder copy(MotorBikeCondition addressEmbeddable)
        {
            this.OdometreReading = addressEmbeddable.OdometreReading;
            this.Gas = addressEmbeddable.Gas;
            this.BikeCondition = addressEmbeddable.BikeCondition;
            return this;
        }

        public MotorBikeCondition build()
        {
            return new MotorBikeCondition(this);
        }
    }
}
