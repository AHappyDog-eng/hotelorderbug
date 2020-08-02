package com.kuang.service;

import com.kuang.entity.operator;
import com.kuang.entity.roomandOperator;
import com.kuang.mapper.operatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class roomaoImp implements roomao {
    @Autowired
    private operatorMapper mapper;

    @Override
    public int addRoomao(operator roomandOperator) {
        int i = mapper.addRoomao(roomandOperator);

        return i;
    }

    @Override
    public int deleteRoomao(String operatroId) {
        int i = mapper.deleteRoomao(operatroId);
        return i;
    }
}
