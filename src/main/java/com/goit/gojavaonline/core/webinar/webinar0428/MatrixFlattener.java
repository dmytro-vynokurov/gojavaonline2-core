package com.goit.gojavaonline.core.webinar.webinar0428;

public class MatrixFlattener {

    public int[] flattenInASimpleWay(int[][] m) {
        if (m.length == 0) return new int[]{};

        int[] result = new int[m.length * m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int index = i * m[i].length + j;
                result[index] = m[i][j];
            }
        }

        return result;
    }

    public int[] flattenInASimpleReversedWay(int[][] m) {
        if (m.length == 0) return new int[]{};

        int[] result = new int[m.length * m[0].length];
        int index = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j =  m[i].length-1; j >= 0; j--) {
                result[index] = m[i][j];
                index++;
            }
        }

        return result;
    }

    public int[] flattenByColumns(int[][] m) {
        if (m.length == 0) return new int[]{};

        int[] result = new int[m.length * m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int index = j * m.length + i;
                result[index] = m[i][j];
            }
        }

        return result;
    }

    public int[] flattenTickTacking(int[][] m) {
        if (m.length == 0) return new int[]{};

        int[] result = new int[m.length * m[0].length];
        int index = 0;

        int startRow = 0;
        int endRow = m.length - 1;
        int i=0;

        while (startRow<=endRow){
            for (int j = 0; j < m[i].length; j++) {
                result[index] = m[i][j];
            }
            if(i==startRow){
                i = endRow;
                startRow++;
            }else{
                i=startRow;
                endRow--;
            }
        }


        return result;
    }

    public int[] flattenHorizontalSnake(int[][] m) {
        if (m.length == 0) return new int[]{};

        int[] result = new int[m.length * m[0].length];
        int index=0;

        int i=0;
        int j=0;
        int direction = 1;

        while (i < m.length) {
            while (j>=0 && j<m[i].length){
                result[index] = m[i][j];
                index++;
                j+=direction;
            }
            i++;
            direction = -1 * direction;
            j += direction;
        }



        return result;
    }



}
