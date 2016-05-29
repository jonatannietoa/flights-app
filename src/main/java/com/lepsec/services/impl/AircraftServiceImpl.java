package com.lepsec.services.impl;

import com.lepsec.controllers.FlightRadarApiController;
import com.lepsec.repositories.AircraftRepository;
import com.lepsec.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jnieto on 29/5/16.
 */
@Service
public class AircraftServiceImpl implements AircraftService {

    private AircraftRepository aircraftRepository;

    private FlightRadarApiController flightRadarApiController;

    @Autowired
    public AircraftServiceImpl(AircraftRepository aircraftRepository, FlightRadarApiController flightRadarApiController) {
        this.aircraftRepository = aircraftRepository;
        this.flightRadarApiController = flightRadarApiController;
    }

    @Override
    public void saveAircraft(String registration) {
        this.aircraftRepository.save(flightRadarApiController.getAircraftByRegistration(registration).getAircraft());
    }
}
