package com.kuang.hotelorderbuy;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.Indent;
import com.kuang.entity.Person;
import com.kuang.entity.Room;
import com.kuang.entity.email.Email;
import com.kuang.service.indentImp;
import com.kuang.service.personImp;
import com.kuang.service.roomImp;
import com.kuang.tools.mailUtils.MailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class HotelorderbuyApplicationTests {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private indentImp imp;
    @Test
    void contextLoads() {
        Integer integer = imp.selectIndentSumMouse("2020-12-14", "2020-12-15");
        System.out.println(integer);
    }

    @Test
    void test1() {
        Arrays.asList("a","b","c").forEach((e) -> System.out.println(e));
    }

}
