package com.lepsec.services.impl;

import com.lepsec.controllers.FlightStatsApiController;
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

    private FlightStatsApiController flightStatsApiController;

    @Autowired
    public AircraftServiceImpl(AircraftRepository aircraftRepository, FlightStatsApiController flightStatsApiController) {
        this.aircraftRepository = aircraftRepository;
        this.flightStatsApiController = flightStatsApiController;
    }

    @Override
    public void saveAircraft(String registration) {
//        this.aircraftRepository.save(flightStatsApiController.getAircraftByRegistration(registration).getAircraft());
    }
}
