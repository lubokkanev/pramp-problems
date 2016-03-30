package com.lubokkanev.pramp.problems;

public class P01SentenceReverser {
    private String sentence;

    public P01SentenceReverser(String sentence) {
        this.sentence = sentence;
    }

    public static void test() {
        String test = "perfect! makes Practice";

        System.out.println("\nSentenceReverser:");
        System.out.println(new P01SentenceReverser(test).smartReverse());
    }

    public String smartReverse() {
        StringBuilder result = new StringBuilder(sentence);

        reverse(result, 0, result.length());
        reverseWords(result);

        return result.toString();
    }

    private void reverse(StringBuilder string, int from, int to) {
        for (int i = 0; i < (to - from) / 2; ++i) {
            swapCharacters(string, from + i, to - 1 - i);
        }
    }

    private void swapCharacters(StringBuilder string, int leftIndex, int rightIndex) {
        char left = string.charAt(leftIndex);
        char right = string.charAt(rightIndex);

        string.setCharAt(leftIndex, right);
        string.setCharAt(rightIndex, left);
    }

    private void reverseWords(StringBuilder string) {
        int start = 0;
        int spaceIndex;

        while ((spaceIndex = string.indexOf(" ", start)) != -1) {
            reverse(string, start, spaceIndex);
            start = spaceIndex + 1;
        }

        reverse(string, start, string.length());
    }
}

