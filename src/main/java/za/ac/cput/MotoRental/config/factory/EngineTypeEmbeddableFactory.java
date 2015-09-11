package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.EngineTypeEmbeddable;

/**
 * Created by student on 2015/08/13.
 */
public class EngineTypeEmbeddableFactory {
    public static EngineTypeEmbeddable createEngineTypeEmbeddable(String EngineSerialNumber, String EngineSize, String FuelType)
    {
        EngineTypeEmbeddable engineTypeEmbeddable = new EngineTypeEmbeddable
                .Builder(EngineSerialNumber)
                .EngineSize(EngineSize)
                .FuelType(FuelType)
                .build();

        return engineTypeEmbeddable;
    }
}

