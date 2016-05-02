package com.lubokkanev.pramp.problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class P05WordCountEngineTest {
    private P05WordCountEngine classUnderTest;
    private final File file = new File("test/resources/test.txt");
    private FileWriter writer;

    @Before
    public void setUp() throws IOException {
        classUnderTest = new P05WordCountEngine(file);
        writer = new FileWriter(file);
    }

    @Test
    public void testCountWords_normal() throws IOException {
        String one = "one";
        String two = "two";
        String three = "three";
        writeToFile(one + " " + two + " " + three + " \n" + two + " " + three + " \n" + three);

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Arrays.asList(new P05WordCountEngine.WordCount(three, 3), new P05WordCountEngine.WordCount(two, 2), new P05WordCountEngine.WordCount(one, 1)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_one() throws IOException {
        String three = "three";
        writeToFile(three + " " + three + "\n" + three);

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Collections.singletonList(new P05WordCountEngine.WordCount(three, 3)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_capitals() throws IOException {
        String three = "three";
        writeToFile("thREE three THREE\ntHrEe \n THRee");

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Collections.singletonList(new P05WordCountEngine.WordCount(three, 5)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_multipleDelimiters() throws IOException {
        String one = "one";
        writeToFile(one + " ;. " + one + " \n; " + one + " ; ");

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Collections.singletonList(new P05WordCountEngine.WordCount(one, 3)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        assertEquals(expectedResult, actualResult);
    }

    @After
    public void tearDown() throws IOException {
        writer.close();
    }

    private void writeToFile(String content) throws IOException {
        writer.write(content);
        writer.flush();
    }
}
