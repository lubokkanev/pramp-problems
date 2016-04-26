package com.lubokkanev.pramp.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P03KMessedArraySorter<T extends Comparable> {
    private List<T> array;
    private int k;
    private PriorityQueue<T> heap;

    public P03KMessedArraySorter(int k, List<T> array) {
        setArray(array);
        setK(k);
        heap = new PriorityQueue<>(determineInitialCapacity(array));
    }

    public void setArray(List<T> array) {
        this.array = array;
    }

    public void setK(int k) {
        if (k > 0) {
            this.k = k;
        } else {
            throw new IllegalArgumentException("K should be bigger than 0. ");
        }
    }

    public List<T> sort() {
        if (array == null) {
            throw new IllegalArgumentException("The array shouldn't be null. ");
        }

        ArrayList<T> sortedArray = new ArrayList<>(array);

        fillFirstKElements();
        kSort(sortedArray);
        heap.clear();

        return sortedArray;
    }

    private int determineInitialCapacity(List<T> array) {
        if (array != null) {
            return array.size();
        } else {
            return 1;
        }
    }

    private void kSort(List<T> array) {
        for (int i = 0; i < array.size(); ++i) {
            setIthToSmallest(i, array);
            expandHeap(i, array);
        }
    }

    private void expandHeap(int i, List<T> array) {
        if (thereAreMoreElements(i)) {
            heap.add(array.get(i + k));
        }
    }

    private boolean thereAreMoreElements(int i) {
        return i + k < array.size();
    }

    private void setIthToSmallest(int i, List<T> array) {
        array.set(i, heap.peek());

        if (!heap.isEmpty()) {
            heap.remove();
        }
    }

    private void fillFirstKElements() {
        for (int i = 0; i < k && i < array.size(); ++i) {
            heap.add(array.get(i));
        }
    }
}
