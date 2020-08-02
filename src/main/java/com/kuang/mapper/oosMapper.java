package com.kuang.mapper;

import com.kuang.entity.oos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface oosMapper {
    /*查询一个url*/
    oos getByOosId(String oosId);
    /*插入一个url*/
    int insertOos(oos oos1);

}
