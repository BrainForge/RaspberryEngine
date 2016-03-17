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
    private Double temp;

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

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
