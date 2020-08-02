package com.kuang.mapper;

import com.kuang.entity.Person;
import com.kuang.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface personMapper {
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
