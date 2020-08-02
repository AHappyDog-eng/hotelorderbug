package com.kuang.entity;

import java.io.Serializable;
import java.util.Date;

public class operator implements Serializable {

    private String operatorId;
    private String operatorName;
    private String operatorDate;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorDate() {
        return operatorDate;
    }

    public void setOperatorDate(String operatorDate) {
        this.operatorDate = operatorDate;
    }

    @Override
    public String toString() {
        return "operator{" +
                "operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorDate=" + operatorDate +
                '}';
    }

    public operator() {
    }

    public operator(String operatorId, String operatorName, String operatorDate) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorDate = operatorDate;
    }
}
