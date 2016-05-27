package com.lepsec.integration.flightradar24;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lepsec.domain.Aircraft;
import com.lepsec.domain.Airport;
import com.lepsec.domain.Flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonatannietoa on 23/05/2016.
 */
public class FlightRadarTraffic implements Serializable{

    private Airport airport = new Airport();

    private List<Flight> arrivals = new ArrayList<>();

    private List<Flight> departures = new ArrayList<>();

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
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

        this.airport.setName((String) details.get("name"));
        Map<String, Object> code = (Map<String, Object>) details.get("code");
        this.airport.setIata((String) code.get("iata"));
        this.airport.setIcao((String) code.get("icao"));

        Map<String, Object> schedule = (Map<String, Object>) pluginData.get("schedule");
        Map<String, Object> arrivals = (Map<String, Object>) schedule.get("arrivals");

        List<Map<String, Object>> data = (List<Map<String, Object>>) arrivals.get("data");

        for (int i = 0; i < data.size(); i++) {
            Flight flight = new Flight();
            Aircraft aircraft = new Aircraft();
            Airport origin = new Airport();

            Map<String, Object> flightMap = (Map<String, Object>) data.get(i).get("flight");
            Map<String, Object> status = (Map<String, Object>) flightMap.get("status");
            flight.setStatus((String) status.get("text"));

            Map<String, Object> identification = (Map<String, Object>) flightMap.get("identification");
            flight.setFlight((String) identification.get("callsign"));

            Map<String, Object> generic = (Map<String, Object>) status.get("generic");
            Map<String, Object> eventTime = (Map<String, Object>) generic.get("eventTime");

            flight.setTime((Integer) eventTime.get("local"));

            Map<String, Object> aircraftMap = (Map<String, Object>) flightMap.get("aircraft");
            Map<String, Object> model = (Map<String, Object>) aircraftMap.get("model");
            aircraft.setModel((String) model.get("code"));
            aircraft.setHex((String) aircraftMap.get("hex"));
            aircraft.setRegistration((String) aircraftMap.get("registration"));
            aircraft.setSerialNo((String) aircraftMap.get("serialNo"));
            aircraft.setOwner((String) aircraftMap.get("owner"));
            flight.setAircraft(aircraft);

            Map<String, Object> airportMap = (Map<String, Object>) flightMap.get("airport");
            Map<String, Object> originMap = (Map<String, Object>) airportMap.get("origin");

            origin.setName((String) originMap.get("name"));
            Map<String, Object> originCodes = (Map<String, Object>) originMap.get("code");
            origin.setIata((String) originCodes.get("iata"));
            origin.setIcao((String) originCodes.get("icao"));

            flight.setFrom(origin);
            flight.setTo(this.airport);

            this.arrivals.add(flight);
        }

        Map<String, Object> departures = (Map<String, Object>) schedule.get("departures");
        List<Map<String, Object>> dataDepartures = (List<Map<String, Object>>) departures.get("data");

        for (int i = 0; i < dataDepartures.size(); i++) {
            Flight flight = new Flight();
            Aircraft aircraft = new Aircraft();
            Airport departure = new Airport();

            Map<String, Object> flightMap = (Map<String, Object>) dataDepartures.get(i).get("flight");
            Map<String, Object> status = (Map<String, Object>) flightMap.get("status");
            flight.setStatus((String) status.get("text"));

            Map<String, Object> identification = (Map<String, Object>) flightMap.get("identification");
            flight.setFlight((String) identification.get("callsign"));

            Map<String, Object> generic = (Map<String, Object>) status.get("generic");
            Map<String, Object> eventTime = (Map<String, Object>) generic.get("eventTime");

            flight.setTime((Integer) eventTime.get("local"));

            Map<String, Object> aircraftMap = (Map<String, Object>) flightMap.get("aircraft");
            Map<String, Object> model = (Map<String, Object>) aircraftMap.get("model");
            aircraft.setModel((String) model.get("code"));
            aircraft.setHex((String) aircraftMap.get("hex"));
            aircraft.setRegistration((String) aircraftMap.get("registration"));
            aircraft.setSerialNo((String) aircraftMap.get("serialNo"));
            aircraft.setOwner((String) aircraftMap.get("owner"));
            flight.setAircraft(aircraft);

            Map<String, Object> airportMap = (Map<String, Object>) flightMap.get("airport");
            Map<String, Object> destinationMap = (Map<String, Object>) airportMap.get("destination");

            departure.setName((String) destinationMap.get("name"));
            Map<String, Object> originCodes = (Map<String, Object>) destinationMap.get("code");
            departure.setIata((String) originCodes.get("iata"));
            departure.setIcao((String) originCodes.get("icao"));

            flight.setFrom(this.airport);
            flight.setTo(departure);

            this.departures.add(flight);
        }
    }
}
