package org.hellforge.raspberry.response;


import org.hellforge.raspberry.entity.ThermometerEntity;

import java.io.Serializable;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
public class ThermometerDTO implements Serializable {

    private int id;
    private String deviceId;
    private Float temp;


    public ThermometerDTO(ThermometerEntity thermometerEntity) {
        this.id = thermometerEntity.getId();
        this.deviceId = thermometerEntity.getDeviceId();
        this.temp = thermometerEntity.getTemp();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }
}
