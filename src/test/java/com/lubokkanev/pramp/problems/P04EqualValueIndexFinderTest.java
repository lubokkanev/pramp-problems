package com.lubokkanev.pramp.problems;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class P04EqualValueIndexFinderTest {

    private P04EqualValueIndexFinder classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new P04EqualValueIndexFinder(null);
    }

    @Test
    public void testFindIndex_oneElement_found() {
        classUnderTest.setArray(new ArrayList<>(Collections.singletonList(0)));

        Integer expectedResult = 0;
        Integer actualResult = classUnderTest.findIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindIndex_oneElement_notFound() {
        classUnderTest.setArray(new ArrayList<>(Collections.singletonList(1)));

        Integer expectedResult = -1;
        Integer actualResult = classUnderTest.findIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindIndex_normal_notFound() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(5, 6, 7)));

        Integer expectedResult = -1;
        Integer actualResult = classUnderTest.findIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindIndex_normal_found() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 4, 5)));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(4,5));
        Integer actualResult = classUnderTest.findIndex();
        assertTrue(expectedResult.contains(actualResult));
    }

    @Test
    public void testFindIndex_longData_found() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-100, -99, -98, -97, -90, -80, -22,
                5, 7, 9, 11)));

        Integer expectedResult = 9;
        Integer actualResult = classUnderTest.findIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindIndex_longData_notFound() {
        classUnderTest.setArray(new ArrayList<>(Arrays.asList(-100, -99, -98, -97, -90, -80, -22,
                5, 7, 10, 11)));

        Integer expectedResult = -1;
        Integer actualResult = classUnderTest.findIndex();
        assertEquals(expectedResult, actualResult);
    }
}
