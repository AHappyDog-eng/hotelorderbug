package com.kuang.mapper;

import com.kuang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userMapper {
    List<User> getAll();

    //根据id选择用户
    User selectUserById(String username);

    //添加一个用户
    int addUser(User user);

    //修改一个用户
    int updateUser(User user);

    //根据id删除用户
    int deleteUser(int id);

    /*登录*/
    User Login(@Param("username") String username, @Param("password") String password);

    /*按照邮箱查询信息*/
    User selectByEmail(String email);

    /*重置密码*/
    int updatePasswrod(@Param("id") int id,@Param("password") String password);

    /*按照昵称查询*/
    List<User> selectByUsername(String username);

    /*按照手机号查询*/
    List<User> selectByTel(String tel);

    /*修改密码*/
    int updatepassword(String password);

    /*根据用户名 密码查询*/
    User selectUser(@Param("id")Integer id,@Param("password")String password);


}
