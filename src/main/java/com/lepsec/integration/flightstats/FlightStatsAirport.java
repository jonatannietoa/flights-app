package com.lepsec.integration.flightstats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lepsec.domain.Airport;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jonatannietoa on 02/06/2016.
 */
public class FlightStatsAirport implements Serializable{
    private Airport airport = new Airport();

    public Airport getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(Map<String, Object> result) {
        this.airport.setName((String) result.get("name"));
        this.airport.setIata((String) result.get("iata"));
        this.airport.setIcao((String) result.get("icao"));
    }
}
