package com.lepsec.controllers;

import com.lepsec.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jnieto on 26/5/16.
 */
@Controller
public class AirportController {
    private AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping("/airport")
    public ModelAndView getAirportByIata(@RequestParam(name = "iata") String iata){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airport", airportService.getAirportByIata(iata));
        modelAndView.addObject("arrivals", airportService.getAirportArrivalsByIata(iata));
        modelAndView.addObject("departures", airportService.getAirportDeparturesByIata(iata));
        modelAndView.setViewName("airport");
        return modelAndView;
    }
}
