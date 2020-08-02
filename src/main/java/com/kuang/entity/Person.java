package com.kuang.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    /*id*/
    private String personid;
    /*姓名*/
    private String personname;
    /*年龄*/
    private String personage;
    /*工作经验*/
    private String personsuffer;
    /*入职日期*/
    private String persondate;
    /*薪资水平*/
    private String personsalary;
    /*电话*/
    private String persontel;
    /*职位*/
    private String personjob;

    @Override
    public String toString() {
        return "Person{" +
                "personid='" + personid + '\'' +
                ", personname='" + personname + '\'' +
                ", personage=" + personage +
                ", personsuffer=" + personsuffer +
                ", persondate=" + persondate +
                ", personsalary=" + personsalary +
                ", persontel='" + persontel + '\'' +
                ", personjob='" + personjob + '\'' +
                '}';
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getPersonage() {
        return personage;
    }

    public void setPersonage(String personage) {
        this.personage = personage;
    }

    public String getPersonsuffer() {
        return personsuffer;
    }

    public void setPersonsuffer(String personsuffer) {
        this.personsuffer = personsuffer;
    }

    public String getPersondate() {
        return persondate;
    }

    public void setPersondate(String persondate) {
        this.persondate = persondate;
    }

    public String getPersonsalary() {
        return personsalary;
    }

    public void setPersonsalary(String personsalary) {
        this.personsalary = personsalary;
    }

    public String getPersontel() {
        return persontel;
    }

    public void setPersontel(String persontel) {
        this.persontel = persontel;
    }

    public String getPersonjob() {
        return personjob;
    }

    public void setPersonjob(String personjob) {
        this.personjob = personjob;
    }

    public Person(String personid, String personname, String personage, String personsuffer, String persondate, String personsalary, String persontel, String personjob) {
        this.personid = personid;
        this.personname = personname;
        this.personage = personage;
        this.personsuffer = personsuffer;
        this.persondate = persondate;
        this.personsalary = personsalary;
        this.persontel = persontel;
        this.personjob = personjob;
    }

    public Person() {
    }


}
