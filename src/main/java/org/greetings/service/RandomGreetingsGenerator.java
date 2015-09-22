package org.greetings.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RandomGreetings

@ApplicationScoped
public class RandomGreetingsGenerator implements GreetingsGenerator {

    static List<String> greetings = new ArrayList<>(Arrays.asList("Hello ", "Welcome, "));
    private Random random = new Random();

    @Override
    public String generate(String name){
        int prefixIndex = random.nextInt(2);

        return greetings.get(prefixIndex) + name;
    }

    @Override
    public void addGreeting(String greeting){
        this.greetings.add(greeting);
    }
}
