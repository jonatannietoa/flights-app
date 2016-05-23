package com.lepsec.integration.flightradar24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class FlightService {

    private static final String FLIGHTS_URL = "https://api.flightradar24.com/common/v1/airport.json?code={airport}&page=1&limit=25&token=N9Yo2__0rZe9dqK08BWmNrB48b76dIU4dLis7bBOB8U";

    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public FlightService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FlightTraffic getFlights(String airport) {
        logger.info("Requesting current flights for {}", airport);
        URI url = new UriTemplate(FLIGHTS_URL).expand(airport);
        return invoke(url, FlightTraffic.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
