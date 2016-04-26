package com.lubokkanev.pramp.problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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

    @Test
    public void testFindElement_longArray() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(22, 30, 31, 39, 80, 85, 95, 96,
                100, 5, 9, 11, 12, 17, 21));
        classUnderTest.setArray(array);

        assertEquals(-1, classUnderTest.findElement(2));
    }

    @Test
    public void testFindElement_mock() {
        int element = 5;
        classUnderTest = mock(P00ShiftedArrayFinder.class);
        stub(classUnderTest.findElement(element)).toReturn(-2);

        assertEquals(-2, classUnderTest.findElement(element));
    }

    @Test (expected = RuntimeException.class)
    public void testSetArray_fail() {
        classUnderTest = mock(P00ShiftedArrayFinder.class);
        when(classUnderTest.verifySortedShifted(null)).thenReturn(false);
        doCallRealMethod().when(classUnderTest).setArray(null);

        classUnderTest.setArray(null);
    }

    @Test
    public void testSetArray_success() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2));
        classUnderTest = mock(P00ShiftedArrayFinder.class);
        when(classUnderTest.verifySortedShifted(array)).thenReturn(true);
        doCallRealMethod().when(classUnderTest).setArray(array);
        doCallRealMethod().when(classUnderTest).getArray();

        classUnderTest.setArray(array);
        assertEquals(array, classUnderTest.getArray());
    }

    @Test
    public void testVerifySortedShifted_success() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = P00ShiftedArrayFinder.class.getDeclaredMethod("verifySortedShifted", List
                .class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(classUnderTest, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)
        )));
    }

    @Test
    public void testVerifySortedShifted_doubleShifted() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 6, 7, 3, 4, 1, 2));
        assertFalse(classUnderTest.verifySortedShifted(array));
    }

    @Test
    public void testVerifySortedShifted_noElements() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList());
        assertFalse(classUnderTest.verifySortedShifted(array));
    }

    @Test
    public void testVerifySortedShifted_descending() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertFalse(classUnderTest.verifySortedShifted(array));
    }

    @Test
    public void testVerifySortedShifted_scrambled() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 436, 2, 54, 2));
        assertFalse(classUnderTest.verifySortedShifted(array));
    }

    @Test
    public void testVerifySortedShifted_sorted() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
        assertTrue(classUnderTest.verifySortedShifted(array));
    }
}

