package org.hellforge.raspberry.parserEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Anton Afanasyeu on 12/14/16.
 */
public class EventEntity {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sid")
    private String sid;
    @JsonProperty("model")
    private String model;
    @JsonProperty("method")
    private String method;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
