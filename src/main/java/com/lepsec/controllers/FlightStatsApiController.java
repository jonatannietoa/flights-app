package com.lepsec.controllers;

import com.lepsec.integration.flightstats.FlightStatsAirport;
import com.lepsec.integration.flightstats.FlightStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonatannietoa on 02/06/2016.
 */
@RestController
@RequestMapping("/api")
public class FlightStatsApiController {
    private final FlightStatsService flightStatsService;

    @Autowired
    public FlightStatsApiController(FlightStatsService flightStatsService) {
        this.flightStatsService = flightStatsService;
    }

    @RequestMapping(value = "/now/airport/{iata}", method = RequestMethod.GET)
    public FlightStatsAirport getTrafficByAirport(@PathVariable String iata) {
        return this.flightStatsService.getAirport(iata);
    }
}
