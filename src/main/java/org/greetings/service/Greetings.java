package org.greetings.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless

public class Greetings {
    @Inject
    @RandomGreetings
    GreetingsGenerator greetingsGenerator;

    public String generatesGreeting(int userId) {
        String fullName = findFullNameById(userId);
        return greetingsGenerator.generate(fullName);
    }

    public String findFullNameById(int userId){
        return "John Smith";
    }
}
