package com.kuang.Interceptors;

import com.alibaba.fastjson.JSON;
import com.kuang.configuraction.customWeb;
import com.kuang.entity.User;
import com.kuang.service.userImp;
import com.kuang.tools.jwtUtils.JwtUtil;
import com.kuang.tools.statuscode;
import com.mysql.cj.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class WebInterceptors extends HandlerInterceptorAdapter {

    @Autowired
    private userImp userImp;

    @Autowired
    private customWeb custom;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger logger = LoggerFactory.getLogger(getClass());
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        User userById = null;
        String username = null;
        StringBuffer requestURL = request.getRequestURL();
        logger.info("路径："+requestURL);
        // 1. 判断 token是否为空
        if (!StringUtils.isNullOrEmpty(token)) {
            try {
                /*解析出来username*/
                username = JwtUtil.parseVer(token);
            } catch (Exception e) {
                /* 解析失败 401*/
                logger.info("tokne 解析失败");

                statuscode nihao = new statuscode(false, 401, "token解析失败");
                comon(request, response, nihao);
                return false;
            }
            // 2.如果没有异常就查询是否过期
            String parseJWT = (String) JwtUtil.parseJWT(token);
            if (parseJWT.equals("success")) {
                logger.info("token 没有过期");
                /* 如果 token 不为空 并且 不抛出异常，并且不过期 在查询数据库是否有这个用户*/
                User selectUserById = userImp.selectUserById(username);
                if (selectUserById != null) {
                    /*查询成功*/
                    return true;
                } else {
                    /*用户账号密码为空*/
                    statuscode nihao = new statuscode(false, 402, "账号密码错误");
                    comon(request, response, nihao);
                    return false;
                }
            } else {
                logger.info("tokne 过期中断程序");
                /*token过期 402*/
                statuscode nihao = new statuscode(false, 401, "token过期，请从新登录获取token");
                comon(request, response, nihao);
                return false;
            }
        } else {
            /*token 为空 返回到登录页面*/
            statuscode nihao = new statuscode(false, 401, "token为空，请重新登录获取");
            comon(request, response, nihao);
            return false;
        }
    }

    public static void comon(HttpServletRequest request, HttpServletResponse response, statuscode statuscode) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            String json = JSON.toJSONString(statuscode);
            response.setContentType("application/json");
            out = response.getWriter();
            // 返回json信息给前端
            out.append(json);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
