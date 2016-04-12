package com.goit.gojavaonline.core.offline.offline2.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearcherTest {

    Searcher searcher = new Searcher();

    @Test
    public void testEmptyInput() {

        int[] input = new int[]{};
        int target = 5;
        int expected = -1;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testSingleSizeInputWithExistingTarget() {

        int[] input = new int[]{5};
        int target = 5;
        int expected = 0;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testMultipleSizeInputWithExistingTarget() {

        int[] input = new int[]{2,3,5,8,9,12,15,17,19};
        int target = 5;
        int expected = 2;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testMultipleSizeInputWithExistingTarget2() {

        int[] input = new int[]{5,8,9,12,15,17,19, 20,67};
        int target = 5;
        int expected = 0;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testMultipleSizeInputWithExistingTarget3() {

        int[] input = new int[]{5,8,9,12,15,17,19, 20,67};
        int target =67;
        int expected = 8;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testMultipleSizeInputWithNonExistingTarget() {

        int[] input = new int[]{5, 8, 9, 12, 15, 17, 19, 20, 67};
        int target = 4;
        int expected = -1;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }

    @Test
    public void testMultipleSizeInputWithNonExistingTarget2() {

        int[] input = new int[]{5, 8, 9, 12, 15, 17, 19, 20, 67};
        int target = 400;
        int expected = -10;

        int result = searcher.find(input, target);

        assertEquals(expected, result);
    }
}