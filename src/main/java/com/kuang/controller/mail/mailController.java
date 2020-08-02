package com.kuang.controller.mail;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.Indent;
import com.kuang.entity.email.Email;
import com.kuang.service.indentImp;
import com.kuang.tools.mailUtils.MailUtils;
import com.kuang.tools.statuscode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class mailController {

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private indentImp indentImp;
    @RequestMapping("/mail/sendmail")
    @ResponseBody
    public String sendMail(@RequestBody String msg) {
        Email email = JSON.parseObject(msg, Email.class);
        Indent indent = indentImp.selectIndentByEmail(email.getFrom());
        System.out.println(indent);
        String success = mailUtils.sendMailOnly(email.getFrom(),indent);
        if (success.equals("true")) {
            return JSON.toJSONString(new statuscode(true,20000,"发送通知邮件成功"));
        } else{
            return JSON.toJSONString(new statuscode(false,400,"发送通知邮件失败"));
        }
    }
}
