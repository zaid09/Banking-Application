package com.bank;


public class Customers {
    private int custId;
    private String name;
    private int age;
    private String loginPwd;
    private int bankId;


    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getBankId() {
        return bankId;
    }
}
