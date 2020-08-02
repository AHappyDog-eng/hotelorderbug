package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.User;
import com.kuang.entity.requestMsg.ById;
import com.kuang.entity.requestMsg.roomoperator;
import com.kuang.tools.jwtUtils.JwtUtil;
import com.kuang.tools.statuscode;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class userCountController {

    @Autowired
    private com.kuang.service.userImp userImp;

    @RequestMapping("/user/addUser")
    @ResponseBody
    public String addUser(@RequestBody String msg) {
        User user = JSON.parseObject(msg, User.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        user.setDate(dateFormat.format(new Date()));
        user.setPassword("123456");
        int i = userImp.addUser(user);
        if (i == 1) {
            return JSON.toJSONString(new statuscode(true, 20000, "插入成功"));
        } else {
            return JSON.toJSONString(new statuscode(true, 400, "插入失败"));
        }
    }

    @RequestMapping("/user/getAll")
    @ResponseBody
    public String getAll() {
        List<User> all = userImp.getAll();
        if (all != null) {
            return JSON.toJSONString(new roomoperator(20000, all));
        } else {
            return JSON.toJSONString(new statuscode(false, 400, "查询出错"));
        }
    }

    /*修改重置密码*/
    @RequestMapping("/user/updatePassword")
    @ResponseBody
    public String updatePassword(@RequestBody String msg) {
        User user = JSON.parseObject(msg, User.class);
        if (user == null) {
            return JSON.toJSONString(new statuscode(false, 400, "更新密码出错"));
        } else {
            int id = userImp.updatePasswrod(user.getId(), "123456");
            if (id == 1) {
                return JSON.toJSONString(new statuscode(true, 20000, "重置密码成功"));
            } else {
                return JSON.toJSONString(new statuscode(false, 400, "更新密码出错"));
            }
        }
    }

    /*修改用户信息*/
    @RequestMapping("/user/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody String msg) {
        User user = JSON.parseObject(msg, User.class);
        int i = userImp.updateUser(user);
        if (i == 1) {
            return JSON.toJSONString(new statuscode(true, 20000, "更新成功"));
        } else {
            return JSON.toJSONString(new statuscode(false, 400, "更新失败"));

        }
    }

    /*查询用户信息*/
    @RequestMapping("/user/selectUsernameOrTel")
    @ResponseBody
    public String selectUsernameOrTel(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        String arraykey = (String) map.get("arraykey");
        List<User> byUsername = userImp.selectByUsername(arraykey);
        if (byUsername.size() == 0) {
            List<User> selectByTel = userImp.selectByTel(arraykey);
            if (selectByTel.size() == 0) {
                return JSON.toJSONString(new statuscode(false, 400, "没有这个username和Tel的用户"));
            } else {
                return JSON.toJSONString(new roomoperator(20000, selectByTel));
            }
        } else {
            return JSON.toJSONString(new roomoperator(20000, byUsername));
        }
    }

    /*删除用户信息*/
    @RequestMapping("/user/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        int id = userImp.deleteUser((Integer) map.get("id"));
        if (id == 1) {
            return JSON.toJSONString(new statuscode(true, 20000, "删除成功"));
        } else {
            return JSON.toJSONString(new statuscode(false, 400, "删除失败"));
        }
    }

    /*修改密码*/
    @RequestMapping("/user/password")
    @ResponseBody
    public String password(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        /*
         * id
         * password
         * oldpassword
         * */
        User user = userImp.selectUser((Integer) map.get("id"), (String) map.get("oldpassword"));
        if (user == null) {
            return JSON.toJSONString(new statuscode(false, 400, "密码验证失败"));
        } else {
            int i = userImp.updatePasswrod((Integer) map.get("id"), (String) map.get("password"));
            if (i == 1) {
                return JSON.toJSONString(new statuscode(true, 20000, "更新成功"));
            } else {
                return JSON.toJSONString(new statuscode(false, 400, "密码验证失败"));
            }
        }
    }

    @RequestMapping("/user/seleteByusername")
    @ResponseBody
    public String seleteByusername(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        String username = JwtUtil.parseVer(token);
        List<User> users = userImp.selectByUsername(username);
        return JSON.toJSONString(new ById(20000,users.get(0)));
    }
}
