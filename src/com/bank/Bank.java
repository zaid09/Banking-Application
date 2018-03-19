package com.bank;

public class Bank {
    private int bankId;
    private String bankName;
    private String ifsc;
    private String branch;
    private int noOfCust;

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setNoOfCust(int noOfCust) {
        this.noOfCust = noOfCust;
    }

    public int getNoOfCust() {
        return noOfCust;
    }

}

