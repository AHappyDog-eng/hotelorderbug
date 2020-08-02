package com.kuang.entity.email;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable {
    private String Subject;
    private String From;
    private String To;
    private String Cc;
    private String Bcc;
    private Date date;
    private String Text;

    public Email(String subject, String from, String to, String text) {
        Subject = subject;
        From = from;
        To = to;
        Text = text;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Subject='" + Subject + '\'' +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", Cc='" + Cc + '\'' +
                ", Bcc='" + Bcc + '\'' +
                ", date=" + date +
                ", Text='" + Text + '\'' +
                '}';
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getCc() {
        return Cc;
    }

    public void setCc(String cc) {
        Cc = cc;
    }

    public String getBcc() {
        return Bcc;
    }

    public void setBcc(String bcc) {
        Bcc = bcc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Email(String subject, String from, String to, String cc, String bcc, Date date, String text) {
        Subject = subject;
        From = from;
        To = to;
        Cc = cc;
        Bcc = bcc;
        this.date = date;
        Text = text;
    }

    public Email(String subject, String from, String to, Date date, String text) {

        Subject = subject;
        From = from;
        To = to;
        this.date = date;
        Text = text;
    }
}
