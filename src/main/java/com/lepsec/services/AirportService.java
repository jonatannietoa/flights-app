package com.lepsec.services;

import com.lepsec.domain.Airport;
import com.lepsec.domain.Flight;

import java.util.List;

/**
 * Created by jnieto on 26/5/16.
 */
public interface AirportService {
    /**
     * Gets airport by iata.
     *
     * @param iata the iata
     * @return the airport by iata
     */
    Airport getAirportByIata(String iata);

    /**
     * Gets airport arrivals by iata.
     *
     * @param iata the iata
     * @return the airport arrivals by iata
     */
    List<Flight> getAirportArrivalsByIata(String iata);

    /**
     * Gets airport departures by iata.
     *
     * @param iata the iata
     * @return the airport departures by iata
     */
    List<Flight> getAirportDeparturesByIata(String iata);
}
