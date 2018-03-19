package com.bank;

public class Accounts {
    private int accNo;
    private int custId;
    private String accType;      // customer perspective operations
    private String ifsc;           // login,changepwd,addpayee,transferfund,getbalance,getaccstatement
    private String transcPwd;      // changepersonaldetails,
    private String AccCreatDate;
    private float transferLimit;
    private float minBalance;
    private float accBalance;


    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccType() {
        return accType;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setTranscPwd(String transcPwd) {
        this.transcPwd = transcPwd;
    }

    public String getTranscPwd() {
        return transcPwd;
    }

    public void setAccCreatDate(String AccCreatDate) {
        this.AccCreatDate = AccCreatDate;
    }

    public String getAccCreatDate() {
        return AccCreatDate;
    }

    public void setTransferLimit(float transferLimit) {
        this.transferLimit = transferLimit;
    }

    public float getTransferLimit() {
        return transferLimit;
    }

    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }

    public float getMinBalance() {
        return minBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    public float getAccBalance() {
        return accBalance;
    }
    
    
}

