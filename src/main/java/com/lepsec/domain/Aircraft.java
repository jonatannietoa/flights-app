package com.lepsec.domain;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by jnieto on 24/5/16.
 */
@Entity
public class Aircraft implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String model;
    private String hex;
    private String registration;
    private String serialNo;
    private String owner;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets version.
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets version.
     *
     * @param version the version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Instantiates a new Aircraft.
     */
    public Aircraft() {}

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets hex.
     *
     * @return the hex
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets hex.
     *
     * @param hex the hex
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /**
     * Gets registration.
     *
     * @return the registration
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Sets registration.
     *
     * @param registration the registration
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * Gets serial no.
     *
     * @return the serial no
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Sets serial no.
     *
     * @param serialNo the serial no
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
