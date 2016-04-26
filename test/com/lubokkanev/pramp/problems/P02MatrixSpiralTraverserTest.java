package com.lubokkanev.pramp.problems;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class P02MatrixSpiralTraverserTest {
    private P02MatrixSpiralTraverser classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new P02MatrixSpiralTraverser(null);
    }

    @Test
    public void testSpiralTraverse_square() {
        int[][] matrix = new int[][]{
                new int[]{10, 11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20, 21},
                new int[]{22, 23, 24, 25, 26, 27},
                new int[]{28, 29, 30, 31, 32, 33},
                new int[]{34, 35, 36, 37, 38, 39},
                new int[]{40, 41, 42, 43, 44, 45}
        };
        classUnderTest.setMatrix(matrix);
        String expected = "10 11 12 13 14 15 21 27 33 39 45 44 43 42 41 40 34 28 22 16 17 18 19 " +
                "20 26 32 38 37 36 35 29 23 24 25 31 30 ";

        assertEquals(expected, classUnderTest.traverseMatrix());
    }

    @Test
    public void testSpiralTraverse_line() {
        int[][] matrix = new int[][]{
                new int[]{10, 11, 12, 13, 14, 15}
        };
        classUnderTest.setMatrix(matrix);
        String expected = "10 11 12 13 14 15 ";

        assertEquals(expected, classUnderTest.traverseMatrix());
    }

    @Test
    public void testSpiralTraverse_rectangle() {
        int[][] matrix = new int[][]{
                new int[]{10, 11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20, 21},
                new int[]{22, 23, 24, 25, 26, 27},
                new int[]{28, 29, 30, 31, 32, 33},
                new int[]{34, 35, 36, 37, 38, 39}
        };
        classUnderTest.setMatrix(matrix);
        String expected = "10 11 12 13 14 15 21 27 33 39 38 37 36 35 34 28 22 16 17 18 19 20 26 " +
                "32 31 30 29 23 24 25 ";

        assertEquals(expected, classUnderTest.traverseMatrix());
    }
}
