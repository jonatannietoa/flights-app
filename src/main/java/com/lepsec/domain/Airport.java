package com.lepsec.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jnieto on 25/5/16.
 */
@Entity
public class Airport implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;
    private String iata;
    private String icao;

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets iata.
     *
     * @return the iata
     */
    public String getIata() {
        return iata;
    }

    /**
     * Sets iata.
     *
     * @param iata the iata
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * Gets icao.
     *
     * @return the icao
     */
    public String getIcao() {
        return icao;
    }

    /**
     * Sets icao.
     *
     * @param icao the icao
     */
    public void setIcao(String icao) {
        this.icao = icao;
    }
}
