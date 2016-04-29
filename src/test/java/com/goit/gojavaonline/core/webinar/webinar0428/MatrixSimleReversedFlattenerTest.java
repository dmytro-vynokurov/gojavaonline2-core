package com.goit.gojavaonline.core.webinar.webinar0428;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixSimleReversedFlattenerTest {

    MatrixFlattener matrixFlattener = new MatrixFlattener();

    @Test
    public void testSingleElementMatrix1() throws Exception {

        int[][] matrix = {{1}};
        int[] expected = {1};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);
    }

    @Test
    public void testSingleElementMatrix2() throws Exception {

        int[][] matrix = {{2}};
        int[] expected = {2};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);
    }

    @Test
    public void testEmptyMatrix1() throws Exception {
        int[][] matrix = {
                {}
        };
        int[] expected = {};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testEmptyMatrix2() throws Exception {
        int[][] matrix = {};
        int[] expected = {};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testSquareMatrix() throws Exception {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[] expected = {3,2,1,6,5,4,9,8,7};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testNonSquareMatrix() throws Exception {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        int[] expected = {4,3,2,1,8,7,6,5,12,11,10,9};

        int[] actualResult = matrixFlattener.flattenInASimpleReversedWay(matrix);

        System.out.println(Arrays.toString(actualResult));

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }



}