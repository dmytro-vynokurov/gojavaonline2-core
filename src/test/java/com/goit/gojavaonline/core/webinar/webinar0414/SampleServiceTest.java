package com.goit.gojavaonline.core.webinar.webinar0414;

import org.junit.Test;

import static org.junit.Assert.*;

public class SampleServiceTest {

    SampleService sampleService = new SampleService();

    //1
    @Test
    public void testDogRenamingSimpleCase() {
        Dog dog = new Dog("Bobby", 5);

        sampleService.renameDog(dog, "Billy");

        assertEquals("Dog renaming should work correctly", "Billy", dog.getName());
    }

    //5
    @Test(timeout = 150L)
    public void testDogRenamingWithNapping(){
        Dog dog = new Dog("Bobby", 5);

        sampleService.renameDogAndTakeANap(dog, "Billy");

        assertEquals("Dog renaming should work correctly", "Billy", dog.getName());
    }

    //6
    @Test
    public void testCallingA5YearOldDogReturnsCorrectResults() throws DogTooYoungException {
        Dog dog = new Dog("Bobby", 5);

        String call = sampleService.call(dog);
        String expected = "Come here Bobby";

        assertEquals("Dog should be called in a correct way", expected, call);
    }

    //6
    @Test(expected = DogTooYoungException.class)
    public void testCallingA0YearOldDogThrowsAnException() throws DogTooYoungException {
        Dog dog = new Dog("Bobby", 0);

        sampleService.call(dog);
    }

    //6
    @Test
    public void testCallingA0YearOldDogThrowsAnExceptionManual(){
        Dog dog = new Dog("Bobby", 0);

        try {
            sampleService.call(dog);
            fail("Exception should be thrown for too young dogs");  //remove and see what happens if method is broken
        } catch (DogTooYoungException e) {
//            assertThat(e.getMessage(), containsString("young"));
        }
    }
}