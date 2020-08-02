package com.kuang.entity;

import java.io.Serializable;
import java.util.Date;

public class Indent implements Serializable {
    private String indentid;
    private String indentroom;
    /*订单时间*/
    private String indentdate;
    private Integer indentprice;
    /*电话*/
    private String indenttel;
    /*用户描述*/
    private String indentremark;
    /*用户邮箱*/
    private String indentEmail;

    private String indentSuccess;

    private String indentName;

    public String getIndentName() {
        return indentName;
    }

    public void setIndentName(String indentName) {
        this.indentName = indentName;
    }

    public Indent(String indentid, String indentroom, String indentdate, Integer indentprice, String indenttel, String indentremark, String indentEmail, String indentSuccess, String indentName) {
        this.indentid = indentid;
        this.indentroom = indentroom;
        this.indentdate = indentdate;
        this.indentprice = indentprice;
        this.indenttel = indenttel;
        this.indentremark = indentremark;
        this.indentEmail = indentEmail;
        this.indentSuccess = indentSuccess;
        this.indentName = indentName;
    }

    public String getIndentEmail() {
        return indentEmail;
    }

    public void setIndentEmail(String indentEmail) {
        this.indentEmail = indentEmail;
    }

    public String getIndentSuccess() {
        return indentSuccess;
    }

    public void setIndentSuccess(String indentSuccess) {
        this.indentSuccess = indentSuccess;
    }

    public Indent(String indentid, String indentroom, String indentdate, Integer indentprice, String indenttel, String indentremark, String indentEmail, String indentSuccess) {
        this.indentid = indentid;
        this.indentroom = indentroom;
        this.indentdate = indentdate;
        this.indentprice = indentprice;
        this.indenttel = indenttel;
        this.indentremark = indentremark;
        this.indentEmail = indentEmail;
        this.indentSuccess = indentSuccess;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "indentid='" + indentid + '\'' +
                ", indentroom='" + indentroom + '\'' +
                ", indentdate=" + indentdate +
                ", indentprice=" + indentprice +
                ", indenttel='" + indenttel + '\'' +
                ", indentremark='" + indentremark + '\'' +
                '}';
    }

    public String getIndentid() {
        return indentid;
    }

    public void setIndentid(String indentid) {
        this.indentid = indentid;
    }

    public String getIndentroom() {
        return indentroom;
    }

    public void setIndentroom(String indentroom) {
        this.indentroom = indentroom;
    }

    public String getIndentdate() {
        return indentdate;
    }

    public void setIndentdate(String indentdate) {
        this.indentdate = indentdate;
    }

    public Integer getIndentprice() {
        return indentprice;
    }

    public void setIndentprice(Integer indentprice) {
        this.indentprice = indentprice;
    }

    public String getIndenttel() {
        return indenttel;
    }

    public void setIndenttel(String indenttel) {
        this.indenttel = indenttel;
    }

    public String getIndentremark() {
        return indentremark;
    }

    public void setIndentremark(String indentremark) {
        this.indentremark = indentremark;
    }

    public Indent() {
    }

    public Indent(String indentid, String indentroom, String indentdate, Integer indentprice, String indenttel, String indentremark) {
        this.indentid = indentid;
        this.indentroom = indentroom;
        this.indentdate = indentdate;
        this.indentprice = indentprice;
        this.indenttel = indenttel;
        this.indentremark = indentremark;
    }
}
