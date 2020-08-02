package com.kuang.service;

import com.kuang.entity.User;

import java.util.List;

public interface user {
    List<User> getAll();
    //根据id选择用户
    User selectUserById(String id);
    //添加一个用户
    int addUser(User user);
    //修改一个用户
    int updateUser(User user);
    //根据id删除用户
    int deleteUser(int id);
    //根据账号密码来登录
    boolean Login(String username,String password);
    /*按照email查询*/
    User selectByEmail(String email);

    /*重置密码*/
    int updatePasswrod(int id,String password);
    /*按照昵称查询*/
    List<User> selectByUsername(String username);
    /*按照手机号查询*/
    List<User> selectByTel(String tel);
    /*修改密码*/
    int updatepassword(String password);

    /*根据用户名 密码查询*/
    User selectUser(Integer id,String password);
}
