package com.kuang.entity.filterMsg;

public class uploadFilter {
    private String oosId;
    private String oosUrl;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public uploadFilter(String oosId, String oosUrl, Integer code) {
        this.oosId = oosId;
        this.oosUrl = oosUrl;
        this.code = code;
    }

    @Override
    public String toString() {
        return "uploadFilter{" +
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

    public uploadFilter() {
    }

    public uploadFilter(String oosId, String oosUrl) {
        this.oosId = oosId;
        this.oosUrl = oosUrl;
    }
}
