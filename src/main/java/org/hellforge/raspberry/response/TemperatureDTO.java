package org.hellforge.raspberry.response;


import org.hellforge.raspberry.entity.TemperatureEntity;
import org.hellforge.raspberry.helper.Helper;

import java.io.Serializable;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
public class TemperatureDTO implements Serializable {

    private String id;
    private Double temp;
    private String date;

    public TemperatureDTO(TemperatureEntity temperatureEntity) {
        this.id = temperatureEntity.getId();
        this.temp = temperatureEntity.getTemp();
        this.date = Helper.FORMAT.format(temperatureEntity.getDate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
