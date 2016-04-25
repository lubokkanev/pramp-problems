package com.lubokkanev.pramp.problems;

import java.io.*;
import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.Stream;

public class P05WordCountEngine {
    static class WordCount {
        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public String word;
        public int count;

        @Override
        public int hashCode() {
            int result = word.hashCode();
            result = 31 * result + count;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WordCount wordCount = (WordCount) o;

            if (count != wordCount.count) return false;
            return word != null ? word.equals(wordCount.word) : wordCount.word == null;

        }
    }

    private File file;
    private BufferedReader reader;
    private Map<String, Integer> map;
    private LinkedList<WordCount> list;

    public P05WordCountEngine(File file) throws FileNotFoundException {
        map = new HashMap<>();
        list = new LinkedList<>();

        this.file = file;
        if (file != null) {
            reader = new BufferedReader(new FileReader(file));
        }
    }

    public void setFile(File file) throws FileNotFoundException {
        this.file = file;
        reader = new BufferedReader(new FileReader(file));
    }

    public List<WordCount> countWords() throws IOException {
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(",|\\.|;| ");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        map = sortByValue(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.addFirst(new WordCount(entry.getKey(), entry.getValue()));
        }

        return list;
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap<>();
        Stream<Map.Entry<String, Integer>> st = map.entrySet().stream();

        st.sorted(Map.Entry.comparingByValue())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }
}
