package com.lubokkanev.pramp.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P00ShiftedArrayFinder {
    private ArrayList<Integer> array;

    public static void test() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(12, 17, 21, 5, 9, 11));
        Integer element = 9;

        System.out.println("\nShiftedArrayFinder:");
        System.out.println(new P00ShiftedArrayFinder(array).findElement(element));
    }

    public P00ShiftedArrayFinder(ArrayList<Integer> array) {
        this.array = array;
    }

    public int findElement(Integer element) {
        int startIndex = getStartIndex();

        if (element < array.get(0)) {
            return startIndex + Collections.binarySearch(array.subList(startIndex, array.size()),
                    element);
        } else {
            return Collections.binarySearch(array.subList(0, startIndex), element);
        }
    }

    private int getStartIndex() {
        int left = 0;
        int right = array.size();
        int mid = -1;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid == 0 || array.get(mid) < array.get(mid - 1)) {
                return mid;
            } else if (array.get(mid) > array.get(0)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return mid;
    }
}
