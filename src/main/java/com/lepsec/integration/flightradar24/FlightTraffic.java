package com.lepsec.integration.flightradar24;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lepsec.domain.Flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonatannietoa on 23/05/2016.
 */
public class FlightTraffic implements Serializable{

    private String name;

    private List<Flight> arrivals = new ArrayList<>();

    private List<Flight> departures = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Flight> arrivals) {
        this.arrivals = arrivals;
    }

    public List<Flight> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Flight> departures) {
        this.departures = departures;
    }

    @JsonProperty("result")
    public void setFlightTraffic(Map<String, Object> results) {
        Map<String, Object> response = (Map<String, Object>) results.get("response");
        Map<String, Object> airport = (Map<String, Object>) response.get("airport");
        Map<String, Object> pluginData = (Map<String, Object>) airport.get("pluginData");
        Map<String, Object> details = (Map<String, Object>) pluginData.get("details");

        setName((String) details.get("name"));

        Map<String, Object> schedule = (Map<String, Object>) pluginData.get("schedule");
        Map<String, Object> arrivals = (Map<String, Object>) schedule.get("arrivals");

        setArrivals((List<Flight>) arrivals.get("data"));

        Map<String, Object> departures = (Map<String, Object>) schedule.get("departures");

        setDepartures((List<Flight>) arrivals.get("data"));
    }
}
