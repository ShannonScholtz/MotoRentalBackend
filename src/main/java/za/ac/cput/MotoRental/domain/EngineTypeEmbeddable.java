package za.ac.cput.MotoRental.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/13.
 */
@Embeddable
public class EngineTypeEmbeddable implements Serializable {

    private String EngineSerialNumber;
    private String EngineSize;
    private String FuelType;

    private EngineTypeEmbeddable()
    {

    }

    public EngineTypeEmbeddable(Builder builder)
    {
        this.EngineSerialNumber = builder.EngineSerialNumber;
        this.EngineSize = builder.EngineSize;
        this.FuelType = builder.FuelType;
    }

    public String getEngineSerialNumber() {
        return EngineSerialNumber;
    }

    public String getEngineSize() {
        return EngineSize;
    }

    public String getFuelType() {
        return FuelType;
    }

    public static class Builder
    {
        private String EngineSerialNumber;
        private String EngineSize;
        private String FuelType;

        public Builder(String EngineSerialNumber)
        {
            this.EngineSerialNumber = EngineSerialNumber;
        }

        public Builder EngineSize(String EngineSize)
        {
            this.EngineSize = EngineSize;
            return this;
        }

        public Builder FuelType(String FuelType)
        {
            this.FuelType = FuelType;
            return this;
        }

        public Builder copy(EngineTypeEmbeddable engineTypeEmbeddable)
        {
            this.EngineSerialNumber = engineTypeEmbeddable.EngineSerialNumber;
            this.EngineSize = engineTypeEmbeddable.EngineSize;
            this.FuelType = engineTypeEmbeddable.FuelType;
            return this;
        }

        public EngineTypeEmbeddable build()
        {
            return new EngineTypeEmbeddable(this);
        }
    }
}