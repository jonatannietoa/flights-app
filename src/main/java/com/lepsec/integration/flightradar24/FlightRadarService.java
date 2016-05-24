package com.lepsec.integration.flightradar24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

/**
 * Created by jonatannietoa on 22/05/2016.
 */
@Service
public class FlightRadarService {

    private static final String FLIGHTS_URL = "https://api.flightradar24.com/common/v1/airport.json?code={airport}&page=1&limit=25&token=N9Yo2__0rZe9dqK08BWmNrB48b76dIU4dLis7bBOB8U";

    private static final String AIRCRAFT_URL = "https://api.flightradar24.com/common/v1/flight/list.json?query={registration}&fetchBy=reg&page=1&limit=25&token=";

    private static final Logger logger = LoggerFactory.getLogger(FlightRadarService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public FlightRadarService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FlightRadarTraffic getFlights(String airport) {
        logger.info("Requesting current flights for {}", airport);
        URI url = new UriTemplate(FLIGHTS_URL).expand(airport);
        return invoke(url, FlightRadarTraffic.class);
    }

    public FlightRadarAircraft getAircraft(String registration) {
        logger.info("Requesting aircraft {}", registration);
        URI url = new UriTemplate(AIRCRAFT_URL).expand(registration);
        return invoke(url, FlightRadarAircraft.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
