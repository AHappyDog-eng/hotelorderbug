package com.kuang.entity.requestMsg;

import com.kuang.entity.roomandOperator;

import java.util.List;

public class roomoperator extends MsgBody {

    public roomoperator(Integer code, Integer total, List objects) {
        super(code, total, objects);
    }
    public roomoperator(Integer code, List objects) {
        super(code, objects);
    }
    public roomoperator() {
        super();
    }

    @Override
    public Integer getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(Integer code) {
        super.setCode(code);
    }

    @Override
    public Integer getTotal() {
        return super.getTotal();
    }

    @Override
    public void setTotal(Integer total) {
        super.setTotal(total);
    }

    @Override
    public List<Object> getObjects() {
        return super.getObjects();
    }

    @Override
    public void setObjects(List<Object> objects) {
        super.setObjects(objects);
    }
}
