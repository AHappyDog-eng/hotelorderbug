package com.kuang.service;

import com.kuang.entity.Indent;

import java.util.List;

public interface indent {
    List<Indent> getAll();

    //根据id选择用户
    Indent selectIndentById(String indentid);

    //添加一个用户
    int addIndent(Indent indent);

    //修改一个用户
    int updateIndent(Indent indent);

    //根据id删除用户
    int deleteIndent(String indentid);

    /*查询邮箱*/
    Indent selectIndentByEmail(String indentEmail);

    /*查询价值*/
    Integer selectIndentSum();

    /*查询本月 数据*/
    Integer selectIndentSumMouse(String pointDate, String endDate);

    /*查询当天的业绩*/
    Integer selectIndentSumDay(String day);

    /*查询首页四个数据*/
    Integer selectFour();
}
