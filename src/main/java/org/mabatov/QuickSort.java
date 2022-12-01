package org.mabatov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            int pivot = list.get(0);

            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot).toList();

            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot).toList();

            return Stream.of(
                            quickSort(less).stream(),
                            Stream.of(pivot),
                            quickSort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }

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
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int subMax = max(Arrays.copyOfRange(arr, 1, arr.length));
        return Math.max(arr[0], subMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 28, 13, 4, 36};

        System.out.println("Sum: " + sum(arr));
        System.out.println("Count: " + count(arr));
        System.out.println("Max: " + max(arr));

        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of(4);
        List<Integer> list3 = List.of(2, 156, 2, 6, 89, 7, 1, 25);
        List<Integer> list4 = List.of(1, 2, 3, 4, 5);

        System.out.print("QuickSort result: ");
        quickSort(list1).forEach(e -> System.out.print(e + " "));

        System.out.print("\nQuickSort result: ");
        quickSort(list2).forEach(e -> System.out.print(e + " "));

        System.out.print("\nQuickSort result: ");
        quickSort(list3).forEach(e -> System.out.print(e + " "));

        System.out.print("\nQuickSort result: ");
        quickSort(list4).forEach(e -> System.out.print(e + " "));
    }
}
