package com.kuang.service;

import com.kuang.entity.Room;
import com.kuang.entity.roomandOperator;
import com.kuang.mapper.roomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class roomImp implements room {
    @Autowired
    private roomMapper roomMapper;
    @Override
    public List<Room> getAll() {
        List<Room> all = roomMapper.getAll();
        return all;
    }

    @Override
    public Room selectRoomById(String roomid) {
        Room room = roomMapper.selectRoomById(roomid);
        return room;
    }

    @Override
    public int addRoom(Room room) {
        int i = roomMapper.addRoom(room);
        return i;
    }

    @Override
    public int updateRoom(Room room) {
        int i = roomMapper.updateRoom(room);
        return i;
    }

    @Override
    public int deleteRoom(String roomid) {
        int i = roomMapper.deleteRoom(roomid);
        return i;
    }

    @Override
    public List<roomandOperator> getroomOperator() {
        List<roomandOperator> roomandOperators = roomMapper.getroomOperator();
        return roomandOperators;
    }

    @Override
    public int updateRoomao(Room room) {
        int i = roomMapper.updateRoomao(room);
        return i;
    }

    @Override
    public int updateIndent(Room room) {
        int i = roomMapper.updateIndent(room);
        return i;
    }

    @Override
    public List<Room> seleteByclass(String roomIndent) {
        List<Room> rooms = roomMapper.seleteByclass(roomIndent);
        return rooms;
    }

    @Override
    public List<Room> seleteClass() {
        List<Room> stringList = roomMapper.seleteClass();
        return stringList;
    }


}
