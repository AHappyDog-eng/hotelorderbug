package com.kuang.service;

import com.kuang.entity.Person;

import java.util.List;

public interface person {
    List<Person> getAll();
    //根据id选择用户
    Person selectPersonById(String personid);
    //添加一个用户
    int addPerson(Person person);
    //修改一个用户
    int updatePerson(Person person);
    //根据id删除用户
    int deletePerson(String personid);
    /*查询分类*/
    List<Person> seleteByclass(String personjob);
    /*返回所有分类 */
    List<Person> seleteClass();
}
