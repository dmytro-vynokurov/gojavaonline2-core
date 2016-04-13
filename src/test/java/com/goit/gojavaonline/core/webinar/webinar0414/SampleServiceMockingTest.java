package com.goit.gojavaonline.core.webinar.webinar0414;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class SampleServiceMockingTest {

    SampleService sampleService;

    @Before
    public void setUp() throws Exception {
        sampleService = new SampleService();
    }

    //11
    @Test
    public void testRandomDogSelection(){
        List<Dog> dogs = Arrays.asList(
                new Dog("d0", 3),
                new Dog("d1", 5),
                new Dog("d2", 15),
                new Dog("d3", 8),
                new Dog("d4", 6),
                new Dog("d5", 2),
                new Dog("d6", 5),
                new Dog("d7", 7),
                new Dog("d8", 5)
        );

        int start = 2;
        int end = 5;
        int index = 3;
        Dog expected = dogs.get(index);

        RandomNumberGenerationService mock = mock(RandomNumberGenerationService.class);
        when(mock.generate(start, end)).thenReturn(index);

        sampleService.randomNumberGenerationService = mock;


        Dog result = sampleService.pickOne(dogs, start, end);


        assertEquals("Correct dog should be picked from the list", expected, result);
    }


    //11
    @Test(expected = DogTooYoungUncheckedException.class)
    public void testRandomDogSelectionThrowsExceptionOnNegativeStartIndex(){
        List<Dog> dogs = Arrays.asList(
                new Dog("d0", 3),
                new Dog("d1", 5),
                new Dog("d2", 15),
                new Dog("d3", 1),
                new Dog("d4", 6),
                new Dog("d5", 2),
                new Dog("d6", 5),
                new Dog("d7", 7),
                new Dog("d8", 5)
        );

        int start = 2;
        int end = 5;
        int index = 3;

        RandomNumberGenerationService mock = mock(RandomNumberGenerationService.class);
        when(mock.generate(start, end)).thenReturn(index);

        sampleService.randomNumberGenerationService = mock;


        sampleService.pickOne(dogs, start, end);
    }












    @Test
    public void testSavingDogToTheFile() throws Exception {
        Dog dog = new Dog("Billy", 4);
        File file = mock(File.class);

        BufferedWriter writerMock = mock(BufferedWriter.class);
        doNothing().when(writerMock).flush();

        DogWritingService dogWritingServiceMock = mock(DogWritingService.class);
        doNothing().when(dogWritingServiceMock).writeDogToWriter(eq(dog), eq(writerMock));

        WriterProvidingService writingProvidingServiceMock = mock(WriterProvidingService.class);
        when(writingProvidingServiceMock.createWriter(file)).thenReturn(writerMock);

        sampleService.dogWritingService = dogWritingServiceMock;
        sampleService.writerProvidingService = writingProvidingServiceMock;

        sampleService.printToFile2(dog, file);

        verify(dogWritingServiceMock, times(1)).writeDogToWriter(eq(dog), eq(writerMock));
        verify(writerMock, times(1)).flush();
    }
}