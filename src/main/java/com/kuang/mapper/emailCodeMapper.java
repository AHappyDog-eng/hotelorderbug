package com.kuang.mapper;

import com.kuang.entity.email.emailCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface emailCodeMapper {
    /*插入 一个对象*/
    int insertEmailCode(emailCode emailCode);

    /*删除一个对象*/
    int deleteEmailCode(String emailCode);

    /*查询*/
    emailCode selectEmailCode(String emailCode);
}
