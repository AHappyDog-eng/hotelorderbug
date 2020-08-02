package com.kuang.tools;

public class loginstatus {
    private Integer code;
    private String token;

    public loginstatus(Integer code, String token) {
        this.code = code;
        this.token = token;
    }

    public loginstatus() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
