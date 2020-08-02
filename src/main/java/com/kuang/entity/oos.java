package com.kuang.entity;

import java.io.Serializable;

public class oos implements Serializable {

    private String oosId;
    private String oosUrl;

    @Override
    public String toString() {
        return "oos{" +
                "oosId='" + oosId + '\'' +
                ", oosUrl='" + oosUrl + '\'' +
                '}';
    }

    public String getOosId() {
        return oosId;
    }

    public void setOosId(String oosId) {
        this.oosId = oosId;
    }

    public String getOosUrl() {
        return oosUrl;
    }

    public void setOosUrl(String oosUrl) {
        this.oosUrl = oosUrl;
    }

    public oos() {
    }

    public oos(String oosId, String oosUrl) {
        this.oosId = oosId;
        this.oosUrl = oosUrl;
    }
}
