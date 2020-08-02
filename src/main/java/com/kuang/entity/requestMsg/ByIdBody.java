package com.kuang.entity.requestMsg;

public class ByIdBody {
    public Integer code;
    public Object object;

    @Override
    public String toString() {
        return "ByIdBody{" +
                "code=" + code +
                ", object=" + object +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ByIdBody() {
    }

    public ByIdBody(Integer code, Object object) {
        this.code = code;
        this.object = object;
    }
}
