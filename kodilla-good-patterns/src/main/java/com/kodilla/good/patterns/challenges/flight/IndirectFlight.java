package com.kodilla.good.patterns.challenges.flight;

import java.util.Objects;

public class IndirectFlight extends Flight {
    private String trough;

    public IndirectFlight(String from, String to , String trough){
        super(from, to);
        this.trough=trough;
    }

    public String getTrough() {
        return trough;
    }

    @Override
    public String toString() {
        return "IndirectFlight{" +
                "from='" + from + '\'' +
                ", trough='" + trough + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IndirectFlight that = (IndirectFlight) o;
        return Objects.equals(trough, that.trough);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trough);
    }
}
