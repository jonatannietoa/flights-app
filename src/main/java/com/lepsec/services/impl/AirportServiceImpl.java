package com.lepsec.services.impl;

import com.lepsec.controllers.FlightRadarApiController;
import com.lepsec.domain.Airport;
import com.lepsec.domain.Flight;
import com.lepsec.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jnieto on 26/5/16.
 */
@Service
public class AirportServiceImpl implements AirportService{
    private FlightRadarApiController flightRadarApiController;

    @Autowired
    public AirportServiceImpl(FlightRadarApiController flightRadarApiController) {
        this.flightRadarApiController = flightRadarApiController;
    }

    @Override
    public Airport getAirportByIata(String iata) {
        return flightRadarApiController.getTrafficByAirport(iata).getAirport();
    }

    @Override
    public List<Flight> getAirportArrivalsByIata(String iata) {
        return flightRadarApiController.getTrafficByAirport(iata).getArrivals();
    }

    @Override
    public List<Flight> getAirportDeparturesByIata(String iata) {
        return flightRadarApiController.getTrafficByAirport(iata).getDepartures();
    }
}
