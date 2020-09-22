package com.kodilla.good.patterns.challenges.orderService;

public class SMSService implements InformationService{
    @Override
    public void inform(User user) {
        System.out.println("Wysłano SMS'a");
    }
}
