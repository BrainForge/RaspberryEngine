package org.hellforge.raspberry.parserEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Anton Afanasyeu on 12/14/16.
 */
public class ParamsEntity {

    @JsonProperty("temperature")
    private Integer temperature;
    @JsonProperty("humidity")
    private Integer humidity;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
