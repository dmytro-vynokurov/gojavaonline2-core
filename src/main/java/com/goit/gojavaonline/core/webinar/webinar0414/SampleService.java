package com.goit.gojavaonline.core.webinar.webinar0414;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SampleService {

    public static final int SLEEPING_TIME_IN_MILLIS = 1000;
    public static final int NAPPING_TIME_IN_MILLIS = 100;

    //1
    public void renameDog(Dog dog, String newName) {
        dog.setName(newName);
    }

    //5
    public void renameDogAndTakeANap(Dog dog, String newName){
        renameDog(dog, newName);
        sleep(NAPPING_TIME_IN_MILLIS);
    }

    //5
    public void renameDogAndTakeASleep(Dog dog, String newName) {
        renameDog(dog, newName);
        sleep(SLEEPING_TIME_IN_MILLIS);
    }

    //5
    private void sleep(int timeInMillis)  {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //6
    public String call(Dog dog) throws DogTooYoungException {
        if(dog.getAge()<2) throw new DogTooYoungException();
        return "Come here " + dog.getName();
    }

    //7-9
    public int getYoungestDogAge(Dog first, Dog second) {
        return Math.max(first.getAge(), second.getAge());
    }

    //7-9
    public int getOldestDogAge(Dog first, Dog second) {
        return Math.max(first.getAge(), second.getAge());
    }

    //10
     RandomNumberGenerationService randomNumberGenerationService = new RandomNumberGenerationService();

    //10
    public Dog pickOne(List<Dog> dogs, int startIndex, int endIndex) {
        if(dogs.isEmpty())
            throw new IllegalArgumentException("No dogs received");

        if (startIndex < 0 || startIndex >= dogs.size())
            throw new IllegalArgumentException("Start index is illegal");

        if (endIndex < startIndex || endIndex >= dogs.size())
            throw new IllegalArgumentException("End index is illegal");

        int index = randomNumberGenerationService.generate(startIndex, endIndex);
        Dog dog = dogs.get(index);

        if(dog.getAge()<=1) throw new DogTooYoungUncheckedException();

        return dog;
    }

    //11 - naive implementation
    public void printToFile1(Dog dog, String fileName) {
        File file = new File(fileName);
        try (
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("Dog:");
            bw.newLine();
            bw.write(dog.getName());
            bw.newLine();
            bw.write(dog.getAge());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Dog saving failed",e);
        }
    }


    WriterProvidingService writerProvidingService = new WriterProvidingService();
    DogWritingService dogWritingService = new DogWritingService();

    //11 - better way of doing it
    public void printToFile2(Dog dog, File file) {
        try (BufferedWriter bw = writerProvidingService.createWriter(file)) {
            dogWritingService.writeDogToWriter(dog, bw);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Dog saving failed",e);
        }
    }
}
