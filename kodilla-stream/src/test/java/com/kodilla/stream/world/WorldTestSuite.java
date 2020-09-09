package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country(new BigDecimal("37980000"));
        Country germany = new Country(new BigDecimal("82790000"));
        Country ukraine = new Country(new BigDecimal("42220000"));
        Country china = new Country(new BigDecimal("1386000000"));
        Country mongolia = new Country(new BigDecimal("3076000"));
        Country india = new Country(new BigDecimal("1339000000"));
        Country bahamas = new Country(new BigDecimal("301790"));
        Country mexico = new Country(new BigDecimal("107563903"));
        Country panama = new Country(new BigDecimal("4000124"));
        Continent europe = new Continent();
        Continent asia = new Continent();
        Continent northAmerica = new Continent();
        World world = new World();
        //When
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(ukraine);
        asia.addCountry(china);
        asia.addCountry(mongolia);
        asia.addCountry(india);
        northAmerica.addCountry(bahamas);
        northAmerica.addCountry(mexico);
        northAmerica.addCountry(panama);
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        //Then
        Assert.assertEquals(new BigDecimal("3002931817"), world.getPeopleQuantity());
    }
}
