package com.kuang.entity.email;

public class emailCode {
    private String emailForm;
    private String emailCode;

    @Override
    public String toString() {
        return "emailCode{" +
                "emailForm='" + emailForm + '\'' +
                ", emailCode='" + emailCode + '\'' +
                '}';
    }

    public String getEmailForm() {
        return emailForm;
    }

    public void setEmailForm(String emailForm) {
        this.emailForm = emailForm;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public emailCode() {
    }

    public emailCode(String emailForm, String emailCode) {
        this.emailForm = emailForm;
        this.emailCode = emailCode;
    }
}
