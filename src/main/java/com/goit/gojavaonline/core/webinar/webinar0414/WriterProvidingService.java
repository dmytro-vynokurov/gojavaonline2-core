package com.goit.gojavaonline.core.webinar.webinar0414;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterProvidingService {

    public BufferedWriter createWriter(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        return  new BufferedWriter(fw);
    }
}
