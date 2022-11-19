package org.mabatov;

public class BinarySearch {

    private static Integer binarySearch(int[] arr, int item) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (item == guess) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 9, 16, 23};

        System.out.println(binarySearch(arr, 16)); // 3
        System.out.println(binarySearch(arr, -2)); // null

    }
}
