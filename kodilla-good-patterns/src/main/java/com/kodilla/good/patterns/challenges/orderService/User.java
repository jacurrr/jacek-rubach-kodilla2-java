package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDate;

public class User {
    private String username;
    private String realName;
    private LocalDate dateOfBirth;


    public User(String username, String realName, LocalDate dateOfBirth) {
        this.username = username;
        this.realName = realName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Username: " + username;
    }
}
