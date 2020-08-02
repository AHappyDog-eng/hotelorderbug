package com.kuang.service;

public interface oos {
    /*查询一个url*/
    com.kuang.entity.oos getByOosId(String oosId);
    /*插入一个url*/
    int insertOos(com.kuang.entity.oos oos1);
}
