package com.goit.gojavaonline.core.webinar.webinar0414;

import java.io.IOException;
import java.io.Writer;

public class DogWritingService {

    public void writeDogToWriter(Dog dog, Writer writer) throws IOException {
        writer.write("Dog:");
        writer.write("\n");
        writer.write(dog.getName());
        writer.write("\n");
        writer.write(dog.getAge());
        writer.write("\n");
    }

}
