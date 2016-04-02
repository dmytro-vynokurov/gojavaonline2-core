package com.goit.gojavaonline.core.codegym.binarysearch;

public class BinarySearchExecutor {
    public int find(int[] array, int target) {
        if(array.length==0) return -1;
        return findRecursively(array, target, 0, array.length - 1);
    }

    private int findRecursively(int[] array, int target, int fromIndex, int toIndex) {
        if(fromIndex==toIndex){
            if(array[fromIndex]==target) {
                return fromIndex;
            } else {
                if(array[fromIndex]>target) return -1 - fromIndex;
                else return -2 - fromIndex;
            }
        }

        if(toIndex-fromIndex==1){
            if(array[fromIndex]==target) return fromIndex;
            if(array[toIndex]==target) return toIndex;

            if(array[toIndex]<target) return -2 - toIndex;
            else if(array[fromIndex]<target) return -1 - toIndex;
            else return -1 - fromIndex;
        }

        int middleIndex = (fromIndex + toIndex) / 2;
        if(array[middleIndex]>target) return findRecursively(array, target, fromIndex, middleIndex);
        if(array[middleIndex]<target) return findRecursively(array, target, middleIndex, toIndex);
        return middleIndex;
    }
}