package com.kuang.entity;

import java.util.List;

public class dataMsg {
    private List<Room> roomData;
    private Integer code;
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public dataMsg(List<Room> roomData, Integer code, Integer total) {
        this.roomData = roomData;
        this.code = code;
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public dataMsg(List<Room> roomData, Integer code) {
        this.roomData = roomData;
        this.code = code;
    }

    public List<Room> getRoomData() {
        return roomData;
    }

    public void setRoomData(List<Room> roomData) {
        this.roomData = roomData;
    }

    public dataMsg(List<Room> roomData) {
        this.roomData = roomData;
    }
}
