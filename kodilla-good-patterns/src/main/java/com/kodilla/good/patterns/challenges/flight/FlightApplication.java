package com.kodilla.good.patterns.challenges.flight;

import static com.kodilla.good.patterns.challenges.flight.FlightDatabase.*;

public class FlightApplication {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();

        FlightsFinder flightFinderService = new FlightsFinder(flightDatabase);

        System.out.println("Flights from Krakow");
        flightFinderService.findFrom(KRAKOW)
                .forEach(System.out::println);

        System.out.println("\nFlights to Poznan");
        flightFinderService.findTo(POZNAN)
                .forEach(System.out::println);

        System.out.println("\nIndirect flights from Krakow to Poznan");
        flightFinderService.findIndirect(KRAKOW, POZNAN)
                .forEach(System.out::println);
    }
}
