package com.lubokkanev.pramp.problems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class P03KMessedArraySorterTest {
    private P03KMessedArraySorter<Integer> classUnderTest;

    private List<Integer> prepareClass(int k, List<Integer> elements) {
        List<Integer> array = new ArrayList<>(elements);

        classUnderTest.setK(k);
        classUnderTest.setArray(array);

        List<Integer> sortedArray = new ArrayList<>(array);
        Collections.sort(sortedArray);

        return sortedArray;
    }

    @Before
    public void setUp() {
        classUnderTest = new P03KMessedArraySorter<>(1, null);
    }

    @Test
    public void testSort_normal() {
        List<Integer> sortedArray = prepareClass(3, Arrays.asList(2, 6, 3, 12, 56, 8));

        assertEquals(sortedArray, classUnderTest.sort());
    }

    @Test
    public void testSort_alreadySorted() {
        List<Integer> sortedArray = prepareClass(3, Arrays.asList(2, 3, 6, 8, 12, 56));

        assertEquals(sortedArray, classUnderTest.sort());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSort_nullArray() {
        assertEquals(null, classUnderTest.sort());
    }

    @Test
    public void testSort_emptyArray() {
        List<Integer> sortedArray = prepareClass(1, Collections.emptyList());

        assertEquals(sortedArray, classUnderTest.sort());
    }

    @Test
    public void testSort_KBiggerThanArray() {
        List<Integer> sortedArray = prepareClass(100, Arrays.asList(2, 3, 6, 8, 12, 56));

        assertEquals(sortedArray, classUnderTest.sort());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSort_zeroK() {
        prepareClass(0, Arrays.asList(2, 3, 6, 8, 12, 56));
        classUnderTest.sort();
    }

    @Test
    public void testSort_repeatedElements() {
        List<Integer> sortedArray = prepareClass(3, Arrays.asList(2, 2, 2, 2, 2, 2));

        assertEquals(sortedArray, classUnderTest.sort());
    }

    @Test
    public void testSort_typeDouble() {
        ArrayList<Double> array = new ArrayList<>(Arrays.asList(2.1, 6.1, 3.1, 12.1, 56.1, 8.1));
        P03KMessedArraySorter<Double> sorter = new P03KMessedArraySorter<>(3, array);
        ArrayList<Double> sortedArray = new ArrayList<>(array);
        Collections.sort(sortedArray);

        assertEquals(sortedArray, sorter.sort());
    }

    @Test
    public void testSort_typeFloat() {
        ArrayList<Float> array = new ArrayList<>(Arrays.asList(2.1f, 6.1f, 3.1f, 12.1f, 56.1f, 8.1f));
        P03KMessedArraySorter<Float> sorter = new P03KMessedArraySorter<>(3, array);
        ArrayList<Float> sortedArray = new ArrayList<>(array);
        Collections.sort(sortedArray);

        assertEquals(sortedArray, sorter.sort());
    }
}
