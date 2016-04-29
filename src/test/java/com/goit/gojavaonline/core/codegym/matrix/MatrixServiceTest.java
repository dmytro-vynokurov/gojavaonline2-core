package com.goit.gojavaonline.core.codegym.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixServiceTest {

    MatrixService matrixService = new MatrixService();

    @Test
    public void testSnakeOneToOneMatrix() throws Exception {

        int[][] matrix = {{1}};
        int[] expected = {1};

        int[] actualResult = matrixService.print(matrix);

        assertArrayEquals(expected, actualResult);
    }
    @Test
    public void testSnakeTwoToTwoMatrix() throws Exception {

        int[][] matrix = {{1,2},{3,4}};
        int[] expected = {1,2,4,3};

        int[] actualResult = matrixService.print(matrix);

        assertArrayEquals(expected, actualResult);
    }

    @Test
    public void testSnakeThreeToFourMatrix() throws Exception {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] expected = {1,2,3,4,8,12,11,10,9,5,6,7};

        int[] actualResult = matrixService.print(matrix);

        assertArrayEquals(expected, actualResult);
    }
}