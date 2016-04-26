package com.lubokkanev.pramp.problems;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class P05WordCountEngineTest {
    private P05WordCountEngine classUnderTest;
    private File file = new File("test/resources/test.txt");

    @Before
    public void setUp() throws IOException {
        classUnderTest = new P05WordCountEngine(null);
    }

    @Test
    public void testCountWords_normal() throws IOException {
        String one = "one";
        String two = "two";
        String three = "three";
        writeToFile(one + " " + two + " " + three + " \n" + two + " " + three + " \n" + three);

        classUnderTest.setFile(file);

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Arrays.asList(new P05WordCountEngine.WordCount(three, 3), new P05WordCountEngine.WordCount(two, 2), new P05WordCountEngine.WordCount(one, 1)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        assertEquals(expectedResult, actualResult);
    }

    private void writeToFile(String content) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(content);
        writer.flush();
        writer.close();
    }
}
