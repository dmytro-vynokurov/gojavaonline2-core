package com.goit.gojavaonline.core.webinar.webinar0414;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

//6
public class SampleServiceExceptionsTest {

    SampleService sampleService = new SampleService();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCallingAOneYearOldDogThrowsAnException() throws DogTooYoungException {
        expectedException.expect(DogTooYoungException.class);
        expectedException.expectMessage("young");
        sampleService.call(new Dog("Bobby", 1));
    }

}