package com.example.exchange.demonbp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Rate {

    @JsonProperty("code")
    private String code;

    @JsonProperty("mid")
    private Double mid;

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
