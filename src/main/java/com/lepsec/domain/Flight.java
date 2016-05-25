package com.lepsec.domain;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by jonatannietoa on 22/05/2016.
 */
public class Flight implements Serializable {
    private Integer time;
    private String flight;
    private Airport from;
    private Airport to;
    private Aircraft aircraft;
    private String status;

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
