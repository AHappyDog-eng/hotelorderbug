package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.User;
import com.kuang.entity.email.emailCode;
import com.kuang.mapper.userMapper;
import com.kuang.service.emailCodeVerifyImp;
import com.kuang.service.indentImp;
import com.kuang.service.user;
import com.kuang.service.userImp;
import com.kuang.tools.jwtUtils.JwtUtil;
import com.kuang.tools.loginstatus;
import com.kuang.tools.mailUtils.MailUtils;
import com.kuang.tools.statuscode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Controller
public class userController {

    @Autowired
    private com.kuang.service.userImp userImp;

    @Autowired
    private emailCodeVerifyImp verifyImp;
    @Autowired
    private MailUtils mailUtils;


    @RequestMapping("/Login")
    @ResponseBody
    public String getuser(@RequestBody String msg) {
        System.out.println("user/login+++++++++++++++++++++++++++++++++++++++++");
        User user = JSON.parseObject(msg, User.class);
        boolean login = userImp.Login(user.getUsername(), user.getPassword());
        if (login == false) {
            return JSON.toJSONString(new statuscode(false, 305, "用户账号密码验证不正确"));
        } else {
            String token = JwtUtil.createJWT(user.getUsername());
            loginstatus loginstatus = new loginstatus(20000, token);
            return JSON.toJSONString(loginstatus);

        }
    }

    /*发送验证码*/
    @RequestMapping("/Email/LoginVerify")
    @ResponseBody
    public String LoginVerify(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        /*随机生成六位验证码*/
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        String mailVerify = mailUtils.sendMailVerify((String) map.get("email"), str.toString());
        if (mailVerify.equals("true")) {
            /*发送成功*/
            int email = verifyImp.insertEmailCode(new emailCode((String) map.get("email"), str.toString()));
            if (email == 1) {
                return JSON.toJSONString(new statuscode(true, 20000, "发送验证码成功"));
            } else {
                return JSON.toJSONString(new statuscode(false, 400, "发送失败"));
            }

        } else {
            return JSON.toJSONString(new statuscode(false, 400, "发送失败"));
        }
    }

    /*验证*/
    @RequestMapping("/Email/Login")
    @ResponseBody
    public String EmailLogin(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        try {
            emailCode emailCode = verifyImp.selectEmailCode((String) map.get("emailCode"));
            if (emailCode == null) {
                return JSON.toJSONString(new statuscode(false,400,"验证码不正确"));
            }else {
                User user = userImp.selectByEmail(emailCode.getEmailForm());
                /*密码验证正确返回token 和状态码 */
                String token = JwtUtil.createJWT(user.getUsername());
                loginstatus loginstatus = new loginstatus(20000, token);
                return JSON.toJSONString(loginstatus);
            }
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false,400,"验证码不正确"));
        } finally {
            verifyImp.deleteEmailCode((String) map.get("emailCode"));
        }
    }
}
