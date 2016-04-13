package com.goit.gojavaonline.core.webinar.webinar0414;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class SampleServiceTimeoutsTest {

    SampleService sampleService = new SampleService();

    @Rule
    public Timeout timeout = new Timeout(150);

    @Test
    public void testDogRenamingWithNapping(){
        Dog dog = new Dog("Bobby", 5);

        sampleService.renameDogAndTakeANap(dog, "Billy");

        assertEquals("Dog renaming should work correctly", "Billy", dog.getName());
    }

    @Test
    public void testDogRenamingWithSleeping(){
        Dog dog = new Dog("Bobby", 5);

        sampleService.renameDogAndTakeASleep(dog, "Billy");

        assertEquals("Dog renaming should work correctly", "Billy", dog.getName());
    }


}