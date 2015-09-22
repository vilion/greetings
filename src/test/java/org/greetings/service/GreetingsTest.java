package org.greetings.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreetingsTest{

    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                        .addClasses(
                            Greetings.class,
                            GreetingsGenerator.class,
                            RandomGreetings.class,
                            RandomGreetingsGenerator.class)
                        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml"            );
    }

    @EJB
    Greetings greetings;

    @Test
    public void shouldCalculateTotalPrice() {
        Greetings greetings = new Greetings();

        greetings.greetingsGenerator = new RandomGreetingsGenerator();

        String message = greetings.generatesGreeting(1);
        assertThat(message, containsString("John Smith"));
    }
}
