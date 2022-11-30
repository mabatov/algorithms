package org.mabatov;

import java.util.Arrays;

public class QuickSort {

    //4.1
    public static int sum(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }

    //4.2
    public static int count(int[] arr) {

        if (arr.length == 0) {
            return 0;
        } else return 1 + count(Arrays.copyOfRange(arr, 1, arr.length));
    }


    public static int max(int[] arr) {
        if(arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int subMax = max(Arrays.copyOfRange(arr, 1, arr.length));
        return Math.max(arr[0], subMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 28, 13, 4, 36};

        System.out.println(sum(arr));
        System.out.println(count(arr));
        System.out.println(max(arr));
    }
}
