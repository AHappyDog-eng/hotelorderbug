package com.kuang.mapper;

import com.kuang.entity.Person;
import com.kuang.entity.Room;
import com.kuang.entity.roomandOperator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface roomMapper {
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
    /*修改表数据的后两项*/
    int updateRoomao(Room room);
    /*修改房间类型*/
    int updateIndent(Room room);
    /*查询分类*/
    List<Room> seleteByclass(String roomIndent);
    /*返回所有分类 */
    List<Room> seleteClass();
}
