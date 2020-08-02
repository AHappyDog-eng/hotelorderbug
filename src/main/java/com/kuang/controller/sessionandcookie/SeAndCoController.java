package com.kuang.controller.sessionandcookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WN
 * @date 2020/8/2 10:48
 */
@RestController
public class SeAndCoController {

    private Logger logger = LoggerFactory.getLogger(SeAndCoController.class);

    @RequestMapping("/session/set")
    public String setSesion(HttpServletRequest request, HttpServletResponse response) {
        // 获取Session
        HttpSession session = request.getSession();
        // session Id 登录会自动生成
        String sessionId = session.getId();
        Cookie sessionId1 = new Cookie("sessionId", sessionId);
        response.addCookie(sessionId1);
        logger.info(sessionId);
        session.setAttribute("msg", "登陆信息测试类");
        session.setAttribute("id", "first 1");
        return sessionId;
    }

    @RequestMapping("/session/get")
    public void getSession(HttpServletRequest request, HttpServletResponse response, String JSESSIONID) {
        HttpSession session = request.getSession();
        Object msg = session.getAttribute("msg");
        logger.info(JSESSIONID);

    }

    @RequestMapping("/cookie/set")
    public void setCoodie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("msg", "Cookie 设置");
        response.addCookie(cookie);
    }
}
