package com.lepsec.controllers;

import com.lepsec.integration.flightradar24.FlightRadarAircraft;
import com.lepsec.integration.flightradar24.FlightRadarService;
import com.lepsec.integration.flightradar24.FlightRadarTraffic;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jonatannietoa on 22/05/2016.
 */
@RestController
@RequestMapping("/api/flights")
public class AirportApiController {

    private final FlightRadarService flightRadarService;

    public AirportApiController(FlightRadarService flightRadarService) {
        this.flightRadarService = flightRadarService;
    }

    @RequestMapping(value = "/now/traffic/{airport}", method = GET)
    public FlightRadarTraffic getTrafficByAirport(@PathVariable String airport) {
        return this.flightRadarService.getFlights(airport);
    }

    @RequestMapping(value = "/now/aircraft/{registration}", method = GET)
    public FlightRadarAircraft getAircraftByRegistration(@PathVariable String registration) {
        return this.flightRadarService.getAircraft(registration);
    }
}
