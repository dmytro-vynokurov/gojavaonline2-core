package com.goit.gojavaonline.core.webinar.webinar0414;

import java.util.Random;

public class RandomNumberGenerationService {

    Random random = new Random();

    public int generate(int start, int end) {
        int generated = random.nextInt(end - start);
        return generated + start;
    }
}
