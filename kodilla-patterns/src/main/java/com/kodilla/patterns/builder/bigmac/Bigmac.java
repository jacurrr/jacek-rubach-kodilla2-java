package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
        private String bun;
        private int burgers;
        private List<String> ingredients = new ArrayList<>();

        public Bigmac.BigMacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public Bigmac.BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public Bigmac.BigMacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, ingredients);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "Bun='" + bun + '\'' +
                ", Burgers='" + burgers + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
