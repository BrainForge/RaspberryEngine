package org.hellforge.raspberry.entity;

import javax.persistence.*;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Entity
@Table(name = "thermometers")
public class ThermometerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "temp")
    private Float temp;

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
