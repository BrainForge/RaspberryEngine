package org.hellforge.raspberry.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Document
public class ThermometerEntity {

    @Id
    private String id;
    @Field("temp")
    private Double temp;

    public ThermometerEntity(String id, Double temp) {
        this.id = id;
        this.temp = temp;
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
