package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        HashMap<Integer, Double> temperatureMap = new HashMap<Integer, Double>();
        temperatureMap.put(0, 25.5);
        temperatureMap.put(1, 26.2);
        temperatureMap.put(2, 24.8);
        temperatureMap.put(3, 25.2);
        temperatureMap.put(4, 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
