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
    private File file;

    @Before
    public void setUp() throws IOException {
        classUnderTest = new P05WordCountEngine(null);
    }

    @Test
    public void testCountWords_normal() throws IOException {
        file = new File("test.txt");
        Writer writer = new FileWriter(file);
        writer.write("one two three \ntwo three \nthree");
        writer.flush();
        writer.close();

        classUnderTest.setFile(file);

        List<P05WordCountEngine.WordCount> expectedResult = new ArrayList<>(Arrays.asList(new P05WordCountEngine.WordCount("three", 3), new P05WordCountEngine.WordCount("two", 2), new P05WordCountEngine.WordCount("one", 1)));
        List<P05WordCountEngine.WordCount> actualResult = classUnderTest.countWords();

        printList(expectedResult);
        printList(actualResult);

        assertEquals(expectedResult, actualResult);
    }

    private void printList(List<P05WordCountEngine.WordCount> list) {
        for (P05WordCountEngine.WordCount wordCount : list) {
            System.out.println(wordCount.word + ": " + wordCount.count);
        }
    }
}
