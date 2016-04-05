package com.lubokkanev.pramp.problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class P01SentenceReverserTest {
    private P01SentenceReverser classUnderTest;
    @Before
    public void setUp() {
        String sentence = "perfect! makes Practice";
        classUnderTest = new P01SentenceReverser(sentence);
    }

    @After
    public void tearDown() {
        classUnderTest = null;
    }

    @Test
    public void testSmartReverse_standard() {
        String expected = "Practice makes perfect!";
        assertEquals(expected, classUnderTest.smartReverse());
    }

    @Test
    public void testSmartReverse_manySpaces() {
        String sentence = "  one  two  three  ";
        classUnderTest.setSentence(sentence);

        String expected = "  three  two  one  ";
        assertEquals(expected, classUnderTest.smartReverse());
    }

    @Test
    public void testSmartReverse_punctuation() {
        String sentence = "one, two: three;";
        classUnderTest.setSentence(sentence);

        String expected = "three; two: one,";
        assertEquals(expected, classUnderTest.smartReverse());
    }

    @Test
    public void testSmartReverse_numbers() {
        String sentence = "one1 two2 three3";
        classUnderTest.setSentence(sentence);

        String expected = "three3 two2 one1";
        assertEquals(expected, classUnderTest.smartReverse());
    }
}
