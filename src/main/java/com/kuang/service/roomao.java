package com.kuang.service;

import com.kuang.entity.Room;
import com.kuang.entity.operator;
import com.kuang.entity.roomandOperator;

import java.util.List;

public interface roomao {

    //添加一个用户
    int addRoomao(operator roomandOperator);

    //根据id删除用户
    int deleteRoomao(String operatroId);
}
