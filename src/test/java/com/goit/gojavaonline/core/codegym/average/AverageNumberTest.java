package com.goit.gojavaonline.core.codegym.average;

import org.junit.Test;

import static org.junit.Assert.*;

public class AverageNumberTest {

    AverageNumber averageNumber = new AverageNumber();

    @Test
    public void test1() throws Exception {
        int actual = averageNumber.average(-3, -3);
        assertEquals(-3, actual);

    }
}