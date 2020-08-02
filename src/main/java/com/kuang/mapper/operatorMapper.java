package com.kuang.mapper;

import com.kuang.entity.operator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface operatorMapper {

    //添加一个用户
    int addRoomao(operator roomandOperator);

    //根据id删除用户
    int deleteRoomao(String operatroId);
}
