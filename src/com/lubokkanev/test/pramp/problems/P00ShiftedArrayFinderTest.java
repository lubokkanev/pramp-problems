package com.lubokkanev.test.pramp.problems;

import com.lubokkanev.main.pramp.problems.P00ShiftedArrayFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class P00ShiftedArrayFinderTest {
    private P00ShiftedArrayFinder classUnderTest;

    @Before
    public void setUp() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(12, 17, 21, 5, 9, 11));
        classUnderTest = new P00ShiftedArrayFinder(array);
    }

    @After
    public void tearDown() {
        classUnderTest = null;
    }

    @Test
    public void testFindElement_onTheLeft() {
        Integer element = 12;
        assertEquals(0, classUnderTest.findElement(element));
    }

    @Test
    public void testFindElement_onTheRight() {
        Integer element = 9;
        assertEquals(4, classUnderTest.findElement(element));
    }

    @Test
    public void testFindElement_missingElementLower() {
        Integer element = 0;
        assertEquals(-1, classUnderTest.findElement(element));
    }

    @Test
    public void testFindElement_missingElementInside() {
        Integer element = 13;
        assertEquals(-1, classUnderTest.findElement(element));
    }

    @Test
    public void testFindElement_missingElementHigher() {
        Integer element = 30;
        assertEquals(-1, classUnderTest.findElement(element));
    }

    @Test
    public void testFindElement_sortedExisting() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 9, 11, 12, 17, 21));
        classUnderTest.setArray(array);

        assertEquals(1, classUnderTest.findElement(9));
    }

    @Test
    public void testFindElement_sortedMissing() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 9, 11, 12, 17, 21));
        classUnderTest.setArray(array);

        assertEquals(-1, classUnderTest.findElement(2));
    }
}

