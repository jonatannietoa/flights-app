package com.lepsec.controllers;

import com.lepsec.services.AircraftService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jnieto on 29/5/16.
 */
@Controller
public class AircraftController {
    private AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @RequestMapping("saveAircraft/{registration}")
    public String saveAircraftByRegistration(@PathVariable("registration") String registration){
        this.aircraftService.saveAircraft(registration);
        return "index";
    }
}
