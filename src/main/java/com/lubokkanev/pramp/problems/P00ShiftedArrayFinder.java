package com.lubokkanev.pramp.problems;

import java.util.ArrayList;
import java.util.List;

public class P00ShiftedArrayFinder {
    private ArrayList<Integer> array;

    public P00ShiftedArrayFinder(ArrayList<Integer> array) {
        this.array = array;
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    public int findElement(Integer element) {
        int startIndex = getStartIndex();

        if (element < array.get(0)) {
            int index = binarySearch(array.subList(startIndex, array.size()),
                    element);
            if (index >= 0) {
                index += startIndex;
            }

            return index;
        } else {
            return binarySearch(array.subList(0, startIndex), element);
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

    private int binarySearch(List<Integer> array, Integer element) {
        return binarySearchRecursion(array, element, 0, array.size() - 1);
    }

    private int binarySearchRecursion(List<Integer> array, Integer element, Integer low,
                                      Integer high) {
        int mid = low + (high - low) / 2;
        if (low > high) {
            return -1;
        } else if (array.get(mid) > element) {
            return binarySearchRecursion(array, element, low, mid - 1);
        } else if (array.get(mid) < element) {
            return binarySearchRecursion(array, element, mid + 1, high);
        } else {
            return mid;
        }
    }
}
