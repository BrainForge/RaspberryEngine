package org.hellforge.raspberry.parserEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton Afanasyeu on 12/14/16.
 */
public class OtherEventEntity extends EventEntity{

    @JsonProperty("params")
    private List<Integer> params = new ArrayList<>();

    public List<Integer> getParams() {
        return params;
    }

    public void setParams(List<Integer> params) {
        this.params = params;
    }
}
