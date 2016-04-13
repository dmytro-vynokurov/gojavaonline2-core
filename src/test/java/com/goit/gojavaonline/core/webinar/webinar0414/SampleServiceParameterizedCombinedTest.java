package com.goit.gojavaonline.core.webinar.webinar0414;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class SampleServiceParameterizedCombinedTest {

    SampleService sampleService = new SampleService();

    private String dog1Name;
    private int dog1Age;
    private String dog2Name;
    private int dog2Age;
    private int expected;

    public SampleServiceParameterizedCombinedTest(String dog1Name, int dog1Age, String dog2Name, int dog2Age, int expected) {
        this.dog1Age = dog1Age;
        this.dog1Name = dog1Name;
        this.dog2Age = dog2Age;
        this.dog2Name = dog2Name;
        this.expected = expected;
    }

    @Parameters(name = "{index}: youngest age of {0}({1}) and {2}({3}) is {4}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"Bobby", 5 , "Katty", 7, 5},
                {"Bobby", 5 , "Katty", 3, 3},
                {"Bobby", 5 , "Katty", 5, 5},
                {"Bobby", 7 , "Katty", 5, 5}
        });
    }

//    @Parameters(name = "{index}: oldest age of {0}({1}) and {2}({3}) is {4}")
//    public static Iterable<Object[]> data2s() {
//        return Arrays.asList(new Object[][]{
//                {"Bobby", 5 , "Katty", 7, 7},
//                {"Bobby", 5 , "Katty", 3, 5},
//                {"Bobby", 5 , "Katty", 5, 5},
//                {"Bobby", 7 , "Katty", 5, 7}
//        });
//    }

    @Test
    public void testGettingYoungestDogAge(){

        Dog dog1 = new Dog(dog1Name, dog1Age);
        Dog dog2 = new Dog(dog2Name, dog2Age);

        int actualResult = sampleService.getYoungestDogAge(dog1, dog2);

        Assert.assertEquals("Service should correctly get youngest dog age", expected, actualResult);
    }

    @Test
    public void testGettingOldestDogAge(){

        Dog dog1 = new Dog(dog1Name, dog1Age);
        Dog dog2 = new Dog(dog2Name, dog2Age);

        int actualResult = sampleService.getOldestDogAge(dog1, dog2);

        Assert.assertEquals("Service should correctly get oldest dog age", expected, actualResult);
    }

}