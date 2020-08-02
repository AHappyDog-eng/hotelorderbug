package com.kuang.service;

import com.kuang.entity.Room;
import com.kuang.entity.roomandOperator;

import java.util.List;

public interface room {
    List<Room> getAll();
    //根据id选择用户
    Room selectRoomById(String roomid);
    //添加一个用户
    int addRoom(Room room);
    //修改一个用户
    int updateRoom(Room room);
    //根据id删除用户
    int deleteRoom(String roomid);
    /*连表查询*/
    List<roomandOperator> getroomOperator();
    /*修改表的后面两项*/
    int updateRoomao(Room room);
    /*修改房间类型*/
    int updateIndent(Room room);
    /*按照分类查询*/
    List<Room> seleteByclass(String roomIndent);
    /*查询到所有的类别*/
    List<Room> seleteClass();

}
