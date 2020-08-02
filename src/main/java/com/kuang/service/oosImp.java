package com.kuang.service;

import com.kuang.mapper.oosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class oosImp implements oos {
    @Autowired
    private oosMapper mapper;
    @Override
    public com.kuang.entity.oos getByOosId(String oosId) {
        com.kuang.entity.oos byOosId = mapper.getByOosId(oosId);
        return byOosId;
    }

    @Override
    public int insertOos(com.kuang.entity.oos oos1) {
        int i = mapper.insertOos(oos1);
        return i;
    }
}
