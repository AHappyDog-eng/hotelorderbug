package com.kuang.entity.requestMsg;

import com.kuang.entity.Room;

import java.util.List;

public class MsgBody {
    public Integer code;
    public Integer total;
    public List objects;

    public MsgBody(Integer code, List objects) {
        this.code = code;
        this.objects = objects;
    }

    public MsgBody(Integer code, Integer total, List<Object> objects) {
        this.code = code;
        this.total = total;
        this.objects = objects;
    }

    public MsgBody() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
