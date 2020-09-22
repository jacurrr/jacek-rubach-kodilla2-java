package com.kodilla.good.patterns.challenges;

import java.util.Objects;
import java.util.stream.Collectors;

public class MovieMain {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String result = movieStore.getMovies().values().stream()
                .map(Objects::toString)
                .collect(Collectors.joining("!"));
        System.out.println(result);
    }
}