package com.goit.gojavaonline.core.codegym.setbit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetZeroTest {

    SetZero setZero = new SetZero();


    @Test
    public void test1() throws Exception {
        int actualResult = setZero.set(1, 1);

        assertEquals(0, actualResult);
    }
}