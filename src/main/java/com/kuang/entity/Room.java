package com.kuang.entity;

import java.io.Serializable;

public class Room implements Serializable {
    /*房间 id*/
    private String roomid;
    /*房间类型*/
    private String roomindent;
    /*房间价格*/
    private Integer roomprice;
    /*房间描述*/
    private String roomdetail;
    public Room(String roomindent) {
        this.roomindent = roomindent;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomid='" + roomid + '\'' +
                ", roomindent='" + roomindent + '\'' +
                ", roomprice=" + roomprice +
                ", roomdetail='" + roomdetail + '\'' +
                '}';
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomindent() {
        return roomindent;
    }

    public void setRoomindent(String roomindent) {
        this.roomindent = roomindent;
    }

    public Integer getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(Integer roomprice) {
        this.roomprice = roomprice;
    }

    public String getRoomdetail() {
        return roomdetail;
    }

    public void setRoomdetail(String roomdetail) {
        this.roomdetail = roomdetail;
    }

    public Room(String roomid, String roomindent, Integer roomprice, String roomdetail) {
        this.roomid = roomid;
        this.roomindent = roomindent;
        this.roomprice = roomprice;
        this.roomdetail = roomdetail;
    }

    public Room() {
    }
}
