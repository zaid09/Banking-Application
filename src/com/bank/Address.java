package com.bank;

public class Address {
    private int adressId;
    private String streetName;
    private String state;
    private String city;
    private int pin;
    private int custId;


    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public int getAdressId() {
        return adressId;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

}

