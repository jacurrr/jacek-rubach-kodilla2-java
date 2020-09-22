package com.kodilla.good.patterns.challenges.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {
    public final static String WROCLAW = "Wroclaw";
    public final static String KRAKOW = "Krakow";
    public final static String WARSZAWA = "Warszawa";
    public final static String POZNAN = "Poznan";
    private List<Flight> flights;

    public FlightDatabase() {
        this.flights = new ArrayList<>();
        this.flights.add(new Flight(WROCLAW, KRAKOW));
        this.flights.add(new Flight(WROCLAW, POZNAN));
        this.flights.add(new Flight(WROCLAW, WARSZAWA));
        this.flights.add(new Flight(POZNAN, WROCLAW));
        this.flights.add(new Flight(POZNAN, WARSZAWA));
        this.flights.add(new Flight(WARSZAWA, KRAKOW));
        this.flights.add(new Flight(WARSZAWA, WROCLAW));
        this.flights.add(new Flight(KRAKOW, POZNAN));
        this.flights.add(new Flight(KRAKOW, WROCLAW));
    }

    public List<Flight> getFlights() {
        return this.flights;
    }
}
