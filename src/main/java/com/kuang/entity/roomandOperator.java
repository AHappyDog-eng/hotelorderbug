package com.kuang.entity;

import java.io.Serializable;
import java.util.Date;

public class roomandOperator implements Serializable {
    /*房间id*/
    private String roomId;
    private String roomIndent;
    private String operatorName;
    private String operatorDate;

    @Override
    public String toString() {
        return "roomandOperator{" +
                "roomId='" + roomId + '\'' +
                ", roomIndent='" + roomIndent + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorDate=" + operatorDate +
                '}';
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomIndent() {
        return roomIndent;
    }

    public void setRoomIndent(String roomIndent) {
        this.roomIndent = roomIndent;
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

    public roomandOperator() {
    }

    public roomandOperator(String roomId, String roomIndent, String operatorId, String operatorName, String operatorDate) {
        this.roomId = roomId;
        this.roomIndent = roomIndent;
        this.operatorName = operatorName;
        this.operatorDate = operatorDate;
    }
}
