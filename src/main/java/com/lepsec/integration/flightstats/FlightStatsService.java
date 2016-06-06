package com.lepsec.integration.flightstats;

import com.lepsec.configuration.FlightsApplicationProperties;
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
 * Created by jonatannietoa on 02/06/2016.
 */
@Service
public class FlightStatsService {
    private static final String AIRPORT_URL = "https://api.flightstats.com/flex/airports/rest/v1/json/iata/{airport}/2016/06/02?appId={appId}&appKey={appKey}";

    private static final Logger logger = LoggerFactory.getLogger(FlightStatsService.class);

    private final RestTemplate restTemplate;

    private final String appId;
    private final String appKey;

    /**
     * Instantiates a new Flight stats service.
     *
     * @param restTemplate the rest template
     * @param properties   the properties
     */
    @Autowired
    public FlightStatsService(RestTemplate restTemplate, FlightsApplicationProperties properties) {
        this.restTemplate = restTemplate;
        this.appId = properties.getApi().getAppId();
        this.appKey = properties.getApi().getAppKey();
    }

    /**
     * Gets airport.
     *
     * @param airport the airport
     * @return the airport
     */
    public FlightStatsAirport getAirport(String airport) {
        logger.info("Requesting AIRPORT for {}", airport);
        URI url = new UriTemplate(AIRPORT_URL).expand(airport, this.appId, this.appKey);
        return invoke(url, FlightStatsAirport.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
