package org.hellforge.raspberry.response;


import org.hellforge.raspberry.entity.ThermometerEntity;

import java.io.Serializable;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
public class ThermometerDTO implements Serializable {

    private String id;
    private Double temp;


    public ThermometerDTO(ThermometerEntity thermometerEntity) {
        this.id = thermometerEntity.getId();
        this.temp = thermometerEntity.getTemp();
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
}
