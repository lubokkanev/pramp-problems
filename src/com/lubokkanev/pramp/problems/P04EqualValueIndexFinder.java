package com.lubokkanev.pramp.problems;

import java.util.List;

public class P04EqualValueIndexFinder {
    private List<Integer> array;

    public P04EqualValueIndexFinder(List<Integer> array) {
        setArray(array);
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public int findIndex() {
        return findIndex(0, array.size() - 1);
    }

    private int findIndex(int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array.get(mid) == mid) {
            return mid;
        } else if (array.get(mid) < mid) {
            return findIndex(mid + 1, end);
        } else {
            return findIndex(start, mid - 1);
        }
    }
}
