package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> countries = new ArrayList<>();

    public void addCountry(Country country){
        countries.add(country);
    }

    public final List<Country> getCountry(){
        return new ArrayList<>(countries);
    }
}
