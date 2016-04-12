package com.goit.gojavaonline.core.offline.offline2.binarysearch;

public class Searcher {

    public int find(int[] array, int target) {
        if(array.length==0) return -1;
        return findRecursively(array, 0, array.length, target);
    }


    public int findRecursively(int[] array, int leftIndex, int rightIndex, int target) {
        if(leftIndex==rightIndex) {

            if(leftIndex>=array.length) return -1 - array.length;
            else if(array[leftIndex]==target) return leftIndex;
            else return -1 - leftIndex;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;

        if (array[middleIndex] == target) return middleIndex;

        if (array[middleIndex] > target) {
            return findRecursively(array, leftIndex, middleIndex, target);
        } else {
            return findRecursively(array, middleIndex + 1, rightIndex, target);
        }
    }
}

