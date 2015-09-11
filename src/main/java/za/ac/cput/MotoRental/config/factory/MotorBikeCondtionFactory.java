package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.MotorBikeConditionEmbeddable;

/**
 * Created by student on 2015/08/19.
 */
public class MotorBikeCondtionFactory {
    public static MotorBikeConditionEmbeddable createAddress(String OdometreReading, String Gas, String BikeCondition)
    {
        MotorBikeConditionEmbeddable addressEmbeddable = new MotorBikeConditionEmbeddable
                .Builder(OdometreReading)
                .Gas(Gas)
                .BikeCondition(BikeCondition)
                .build();

        return addressEmbeddable;
    }
}