package com.bank;

public class PasswordDetails {
    private int pwdId;
    private int custId;
    private int accNo;
    private String oldLoginPwd;
    private String newLoginPwd;
    private String loginPwdCreateDateTime;
    private String newTranscPwd;
    private  String oldTranscPwd;
    private String transPwdCreateDateTime;


    public void setPwdId(int pwdId) {
        this.pwdId = pwdId;
    }

    public int getPwdId() {
        return pwdId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setOldLoginPwd(String oldLoginPwd) {
        this.oldLoginPwd = oldLoginPwd;
    }

    public String getOldLoginPwd() {
        return oldLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setLoginPwdCreateDateTime(String loginPwdCreateDateTime) {
        this.loginPwdCreateDateTime = loginPwdCreateDateTime;
    }

    public String getLoginPwdCreateDateTime() {
        return loginPwdCreateDateTime;
    }

    public void setNewTranscPwd(String newTranscPwd) {
        this.newTranscPwd = newTranscPwd;
    }

    public String getNewTranscPwd() {
        return newTranscPwd;
    }

    public void setOldTranscPwd(String oldTranscPwd) {
        this.oldTranscPwd = oldTranscPwd;
    }

    public String getOldTranscPwd() {
        return oldTranscPwd;
    }

    public void setTransPwdCreateDateTime(String transPwdCreateDateTime) {
        this.transPwdCreateDateTime = transPwdCreateDateTime;
    }

    public String getTransPwdCreateDateTime() {
        return transPwdCreateDateTime;
    }
}

