package org.greetings.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless

public class Greetings {
    @Inject
    GreetingsGenerator greetingsGenerator;

    public String generateGreeting(int userId) {
        String fullName = findFullNameById(userId);
        return greetingsGenerator.generate(fullName);
    }

    public findFullNameById(int userId){
        return "John Smith";
    }
}
