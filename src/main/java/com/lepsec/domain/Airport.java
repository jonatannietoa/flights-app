package com.lepsec.domain;

import java.io.Serializable;

/**
 * Created by jnieto on 25/5/16.
 */
public class Airport implements Serializable{
    private String name;
    private String iata;
    private String icao;

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
