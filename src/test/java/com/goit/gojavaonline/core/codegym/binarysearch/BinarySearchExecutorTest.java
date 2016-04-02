package com.goit.gojavaonline.core.codegym.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchExecutorTest {

    private BinarySearchExecutor binarySearchExecutor = new BinarySearchExecutor();

    @Test
    public void testEmptyArray() {
        int[] ints = {};

        int resultIndex = binarySearchExecutor.find(ints, 4);
        int expectedIndex = -1;

        assertEquals("Search executor should find element index for a single element array case", expectedIndex, resultIndex);
    }

    @Test
    public void testSingleElementArrayPositiveCase() {
        int[] ints = {4};

        int resultIndex = binarySearchExecutor.find(ints, 4);
        int expectedIndex = 0;

        assertEquals("Search executor should find element index for a single element array case", expectedIndex, resultIndex);
    }

    @Test
    public void testSingleElementArrayNegativeCase() {
        int[] ints = {5};

        int resultIndex = binarySearchExecutor.find(ints, 4);
        int expectedIndex = -1;

        assertEquals("Search executor should return -1 - (expected index) in case element is not present", expectedIndex, resultIndex);
    }

    @Test
    public void testSingleElementArrayNegativeCase2() {
        int[] ints = {1};

        int resultIndex = binarySearchExecutor.find(ints, 5);
        int expectedIndex = -2;

        assertEquals("Search executor should return -1 - (expected index) in case element is not present", expectedIndex, resultIndex);
    }

    @Test
    public void testMultiElementArrayPositiveCase() {
        int[] ints = {2, 4, 7, 8, 9, 10};

        int resultIndex = binarySearchExecutor.find(ints, 4);
        int expectedIndex = 1;

        assertEquals("Search executor should find element index", expectedIndex, resultIndex);
    }

    @Test
    public void testMultiElementArrayNegativeCase() {
        int[] ints = {2, 5, 7, 8, 9, 10};

        int resultIndex = binarySearchExecutor.find(ints, 4);
        int expectedIndex = -1 - 1;

        assertEquals("Search executor should find element index", expectedIndex, resultIndex);
    }

    @Test
    public void testMultiElementArrayNegativeCase2() {
        int[] ints = {2, 5};

        int resultIndex = binarySearchExecutor.find(ints, 1);
        int expectedIndex = -1;

        assertEquals("Search executor should find element index", expectedIndex, resultIndex);
    }

    @Test
    public void testMultiElementArrayNegativeCase3() {
        int[] ints = {2, 5};

        int resultIndex = binarySearchExecutor.find(ints, 6);
        int expectedIndex = -3;

        assertEquals("Search executor should find element index", expectedIndex, resultIndex);
    }
}