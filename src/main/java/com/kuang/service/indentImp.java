package com.kuang.service;

import com.kuang.configuraction.config.TargetDataSource;
import com.kuang.configuraction.enumconfig.DataSourceKey;
import com.kuang.entity.Indent;
import com.kuang.entity.Room;
import com.kuang.mapper.indentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indentImp implements indent {
    @Autowired
    private indentMapper indentMapper;
    @Override
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
    public List<Indent> getAll() {
        List<Indent> all = indentMapper.getAll();
        return all;
    }

    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
    @Override
    public Indent selectIndentById(String indentid) {
        Indent indent = indentMapper.selectIndentById(indentid);
        return indent;
    }

    @Override
    public int addIndent(Indent indent) {
        int i = indentMapper.addIndent(indent);
        return i;
    }

    @Override
    public int updateIndent(Indent indent) {
        int i = indentMapper.updateIndent(indent);
        return i;
    }

    @Override
    public int deleteIndent(String indentid) {
        int i = indentMapper.deleteIndent(indentid);
        return i;
    }
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
    @Override
    public Indent selectIndentByEmail(String indentEmail) {
        Indent indent = indentMapper.selectIndentByEmail(indentEmail);
        return indent;
    }

    @Override
    public Integer selectIndentSum() {
        Integer integer = indentMapper.selectIndentSum();
        return integer;
    }

    @Override
    public Integer selectIndentSumMouse(String pointDate, String endDate) {
        Integer integer = indentMapper.selectIndentSumMouse(pointDate, endDate);
        return integer;
    }

    @Override
    public Integer selectIndentSumDay(String day) {
        Integer integer = indentMapper.selectIndentSumDay(day);
        return integer;
    }

    @Override
    public Integer selectFour() {
        Integer integer = indentMapper.selectFour();
        return integer;
    }
}
