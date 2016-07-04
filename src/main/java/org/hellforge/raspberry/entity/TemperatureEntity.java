package org.hellforge.raspberry.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by Anton Afanasyeu on 27.06.16.
 */
@Document
public class TemperatureEntity {

    @Field("idDevice")
    private String idDevice;
    @Field("temp")
    private Double temp;
    @Field("date")
    private Date date;

    public TemperatureEntity(String idDevice, Double temp, Date date) {
        this.idDevice = idDevice;
        this.temp = temp;
        this.date = date;
    }

    public TemperatureEntity() {
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return idDevice;
    }

    public void setId(String idDevice) {
        this.idDevice = idDevice;
    }
}
