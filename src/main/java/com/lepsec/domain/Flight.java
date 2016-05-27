package com.lepsec.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jonatannietoa on 22/05/2016.
 */
@Table
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "flight_time")
    private Integer time;

    private String flight;

    @Column(name = "flight_from")
    private Airport from;

    @Column(name = "flight_to")
    private Airport to;

    private Aircraft aircraft;

    @Column(name = "flight_status")
    private String status;

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
     * Gets time.
     *
     * @return the time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * Gets flight.
     *
     * @return the flight
     */
    public String getFlight() {
        return flight;
    }

    /**
     * Sets flight.
     *
     * @param flight the flight
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    @OneToOne
    @JoinColumn
    public Airport getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(Airport from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    @OneToOne
    @JoinColumn
    public Airport getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(Airport to) {
        this.to = to;
    }

    /**
     * Gets aircraft.
     *
     * @return the aircraft
     */
    @OneToOne
    @JoinColumn
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * Sets aircraft.
     *
     * @param aircraft the aircraft
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
