package com.goit.gojavaonline.core.webinar.webinar0428;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTickTackingFlattenerTest {

    MatrixFlattener matrixFlattener = new MatrixFlattener();

    @Test
    public void testSingleElementMatrix1() throws Exception {

        int[][] matrix = {{1}};
        int[] expected = {1};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);
    }

    @Test
    public void testSingleElementMatrix2() throws Exception {

        int[][] matrix = {{2}};
        int[] expected = {2};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);
    }

    @Test
    public void testEmptyMatrix1() throws Exception {
        int[][] matrix = {
                {}
        };
        int[] expected = {};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testEmptyMatrix2() throws Exception {
        int[][] matrix = {};
        int[] expected = {};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

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
        int[] expected = {1,2,3,7,8,9,4,5,6};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testNonSquareMatrix2() throws Exception {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12},
                {13,14,15},
                {16,17,18},
        };
        int[] expected = {1,2,3,16,17,18,4,5,6,13,14,15,7,8,9,10,11,12};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

    @Test
    public void testNonSquareMatrix1() throws Exception {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        int[] expected = {1,2,3,4,9,10,11,12,5,6,7,8};

        int[] actualResult = matrixFlattener.flattenTickTacking(matrix);

        Assert.assertArrayEquals("Matrix should be correctly flattened for the 1x1 case",
                expected, actualResult);

    }

}