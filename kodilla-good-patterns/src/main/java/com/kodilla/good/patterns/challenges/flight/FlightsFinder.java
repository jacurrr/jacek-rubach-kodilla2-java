package com.kodilla.good.patterns.challenges.flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFinder {
    private FlightDatabase flightDatabase;

    public FlightsFinder(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public List<Flight> findFrom(String from) {
        return flightDatabase.getFlights().stream()
                .filter(flight -> flight.getFrom().equals(from))
                .collect(Collectors.toList());
    }

    public List<Flight> findTo(String to) {
        return flightDatabase.getFlights().stream()
                .filter(flight -> flight.getTo().equals(to))
                .collect(Collectors.toList());
    }

    public List<IndirectFlight> findIndirect(String from, String to) {
        return flightDatabase.getFlights().stream()
                .filter(flight -> flight.getFrom().equals(from))
                .flatMap(flight -> flightDatabase.getFlights().stream()
                        .filter(f -> f.getFrom().equals(flight.getTo()))
                        .map(f -> new IndirectFlight(flight.getFrom(), f.getTo(), flight.getTo())))
                .filter(flight1 -> flight1.getTo().equals(to))
                .collect(Collectors.toList());
    }
}
