package com.lepsec.domain;

import java.io.Serializable;

/**
 * Created by jnieto on 24/5/16.
 */
public class Aircraft implements Serializable{
    private String model;
    private String hex;
    private String registration;
    private String serialNo;
    private String owner;

    public Aircraft() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
