package com.kuang.service;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.User;
import com.kuang.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userImp implements user {
    @Autowired
    private userMapper userMapper;
    @Override
    public List<User> getAll() {
        List<User> all = userMapper.getAll();
        return all;
    }

    @Override
    public User selectUserById(String id) {
        User userById = userMapper.selectUserById(id);
        return userById;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i;
    }

    @Override
    public int deleteUser(int id) {
        int i = userMapper.deleteUser(id);
        return i;
    }

    @Override
    public boolean Login(String username, String password) {
        User login = userMapper.Login(username, password);
        if (login == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User selectByEmail(String email) {
        User user = userMapper.selectByEmail(email);
        return user;
    }

    @Override
    public int updatePasswrod(int id,String password) {
        int i = userMapper.updatePasswrod(id,password);
        return i;
    }

    @Override
    public List<User> selectByUsername(String username) {
        List<User> users = userMapper.selectByUsername(username);
        return users;
    }

    @Override
    public List<User> selectByTel(String tel) {
        List<User> userList = userMapper.selectByTel(tel);
        return userList;
    }

    @Override
    public int updatepassword(String password) {
        int updatepassword = userMapper.updatepassword(password);
        return updatepassword;
    }

    @Override
    public User selectUser(Integer id, String password) {

        User user = userMapper.selectUser(id, password);
        return user;
    }
}
