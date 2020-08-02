package com.kuang.tools.mailUtils;

import com.kuang.entity.Indent;
import com.kuang.entity.email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MailUtils {
    @Autowired
    private JavaMailSender javaMailSender;
    public String sendMail(Email email) {
        /*发送邮件*/
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(email.getSubject());
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setCc(email.getCc());
        message.setBcc(email.getBcc());
        message.setSentDate(email.getDate());
        message.setText(email.getText());
        try {
            javaMailSender.send(message);
            return "true";
        } catch (MailException e) {
            return "false";
        }
    }

    public String sendMailOnly(String email, Indent indent) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("酒店入住通知");
        message.setFrom("WangNingJava@163.com");
        message.setTo(email);
        if (indent.getIndentSuccess().equals("1")){
            message.setText("尊敬的用户 "+indent.getIndentName()+" 你好，欢迎访问我们的酒店，您于"+indent.getIndentdate()+"预定了一间"+indent.getIndentName()+"酒店已经同意入住请与当天下午 2:00 后入住，祝您愉快");
        }else {
            message.setText("尊敬的用户 "+indent.getIndentName()+" 你好，欢迎访问我们的酒店，您于"+indent.getIndentdate()+"预定了一间"+indent.getIndentName()+"由于酒店的不可预防因素导致您的入住失败，欢迎下次预定，谢谢！");
        }
        try {
            javaMailSender.send(message);
            return "true";
        } catch (MailException e) {
            return "false";
        }
    }

    public String sendMailVerify(String email,String verifyCode) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(new Date());
        simpleMailMessage.setSubject("酒店后台登录验证码");
        simpleMailMessage.setFrom("WangNingJava@163.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText("尊敬的用户你好 你于： "+format+" 登录请求 您的验证码是"+verifyCode+"，如果不是您亲人登录，请忽略此消息，谢谢！");
        try {
            javaMailSender.send(simpleMailMessage);
            return "true";
        } catch (MailException e) {
            return "false";
        }
    }
}
