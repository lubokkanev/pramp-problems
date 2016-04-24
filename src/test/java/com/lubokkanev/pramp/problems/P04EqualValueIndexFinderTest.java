package com.lubokkanev.pramp.problems;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class P04EqualValueIndexFinderTest {

    private P04EqualValueIndexFinder classUnderTest;

    private <T> boolean inSet(T result, HashSet<T> rightAnswers) {
        for (T answer : rightAnswers) {
            if (answer.equals(result)) {
                return true;
            }
        }

        return false;
    }

    @Before
    public void setUp() {
        classUnderTest = new P04EqualValueIndexFinder(null);
    }

    @Test
    public void testFindIndex_oneElement_found() {
        classUnderTest.setArray(new ArrayList<>(Collections.singletonList(0)));

        assertEquals(0, classUnderTest.findIndex());
    }

    @Test
    public void testFindIndex_oneElement_notFound() {
        classUnderTest.setArray(new ArrayList<>(Collections.singletonList(1)));

        assertEquals(-1, classUnderTest.findIndex());
    }

    @Test
    public void testFindIndex_normal_notFound() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(5, 6, 7)));

        assertEquals(-1, classUnderTest.findIndex());
    }

    @Test
    public void testFindIndex_normal_found() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 4, 5)));

        assertTrue(inSet(classUnderTest.findIndex(), new HashSet<>(Arrays.asList(4,5))));
    }

    @Test
    public void testFindIndex_longData_found() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-100, -99, -98, -97, -90, -80, -22,
                5, 7, 9, 11)));

        assertEquals(9, classUnderTest.findIndex());
    }

    @Test
    public void testFindIndex_longData_notFound() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-100, -99, -98, -97, -90, -80, -22,
                5, 7, 10, 11)));

        assertEquals(-1, classUnderTest.findIndex());
    }
}
