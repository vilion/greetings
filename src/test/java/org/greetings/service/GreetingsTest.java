package org.greetings.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class GreetingsTest{

    @Test
    public void shouldCalculateTotalPrice() {
        Greetings greetings = new Greetings();

        greetings.greetingsGenerator = new RandomGreetingsGenerator();

        String message = greetings.generatesGreeting(1);
        assertThat(message, containsString("John Smith"));
    }
}
