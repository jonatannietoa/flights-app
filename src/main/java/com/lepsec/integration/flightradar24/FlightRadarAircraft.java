package com.lepsec.integration.flightradar24;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lepsec.domain.Aircraft;
import com.lepsec.domain.Flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonatannietoa on 24/5/16.
 */
public class FlightRadarAircraft implements Serializable {
    private Aircraft aircraft = new Aircraft();
    private List<Flight> flights = new ArrayList<>();

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @JsonProperty("result")
    public void setFlightTraffic(Map<String, Object> result) {
        Map<String, Object> response = (Map<String, Object>) result.get("response");
        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
        Map<String, Object> aircraftMap = data.get(0);
        Map<String, Object> aircraft = (Map<String, Object>) aircraftMap.get("aircraft");
        Map<String, Object> model = (Map<String, Object>) aircraft.get("model");

        this.aircraft.setModel((String) model.get("text"));
        this.aircraft.setHex((String) aircraft.get("hex"));
        this.aircraft.setRegistration((String) aircraft.get("registration"));
        this.aircraft.setSerialNo((String) aircraft.get("serialNo"));
        this.aircraft.setOwner((String) aircraft.get("owner"));

        for (int i = 0; i < data.size(); i++) {
            Flight flight = new Flight();



            Map<String, Object> stringObjectMap =  data.get(i);

        }
    }
}
