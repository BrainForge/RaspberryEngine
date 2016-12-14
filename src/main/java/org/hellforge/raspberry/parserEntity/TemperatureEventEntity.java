package org.hellforge.raspberry.parserEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Anton Afanasyeu on 12/14/16.
 */
public class TemperatureEventEntity extends EventEntity {

    @JsonProperty("params")
    private ParamsEntity params;

    public ParamsEntity getParams() {
        return params;
    }

    public void setParams(ParamsEntity params) {
        this.params = params;
    }
}
