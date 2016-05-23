package com.lepsec.controllers;

import com.lepsec.integration.flightradar24.FlightService;
import com.lepsec.integration.flightradar24.FlightTraffic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonatannietoa on 22/05/2016.
 */
@RestController
@RequestMapping("/api/flights")
public class AirportApiController {

    private static final Logger logger = LoggerFactory.getLogger(AirportApiController.class);

    private final FlightService flightService;

    public AirportApiController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping("/now/traffic/{airport}")
    public FlightTraffic getWeather(@PathVariable String airport) {
        return this.flightService.getFlights(airport);
    }
}
