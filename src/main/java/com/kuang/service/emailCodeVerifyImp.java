package com.kuang.service;

import com.kuang.entity.email.emailCode;
import com.kuang.mapper.emailCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class emailCodeVerifyImp implements emailCodeVerify {

    @Autowired
    private emailCodeMapper emailCodeMapper;
    @Override
    public int insertEmailCode(emailCode emailCode) {
        int i = emailCodeMapper.insertEmailCode(emailCode);
        return i;
    }

    @Override
    public int deleteEmailCode(String emailCode) {
        int i = emailCodeMapper.deleteEmailCode(emailCode);
        return i;
    }

    @Override
    public emailCode selectEmailCode(String emailCode) {
        com.kuang.entity.email.emailCode emailCode1 = emailCodeMapper.selectEmailCode(emailCode);
        return emailCode1;
    }
}
