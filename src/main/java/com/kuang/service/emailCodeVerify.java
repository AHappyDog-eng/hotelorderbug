package com.kuang.service;

import com.kuang.entity.email.emailCode;

public interface emailCodeVerify {

    /*插入 一个对象*/
    int insertEmailCode(emailCode emailCode);

    /*删除一个对象*/
    int deleteEmailCode(String emailCode);

    /*查询*/
    emailCode selectEmailCode(String emailCode);
}
