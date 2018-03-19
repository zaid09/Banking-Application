package com.bank;


public class TransactionDetails {
    private int transcId;
    private String referenceNo;
    private int accNo;
    private String transcType;
    private String transcDateTime;
    private int bankId;
    private String ifsc;
    private float transferAmount;


    public void setTranscId(int transcId) {
        this.transcId = transcId;
    }

    public int getTranscId() {
        return transcId;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setTranscType(String transcType) {
        this.transcType = transcType;
    }

    public String getTranscType() {
        return transcType;
    }

    public void setTranscDateTime(String transcDateTime) {
        this.transcDateTime = transcDateTime;
    }

    public String getTranscDateTime() {
        return transcDateTime;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setTransferAmount(float transferAmount) {
        this.transferAmount = transferAmount;
    }

    public float getTransferAmount() {
        return transferAmount;
    }

}


