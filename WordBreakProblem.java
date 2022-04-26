package com.demo.assessment.Problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Word Break Problem | DP-32
 * Difficulty Level : Hard
 * Last Updated : 31 Mar, 2022
 * Given an input string and a dictionary of words, find out if the input string can be
 * segmented into a space-separated sequence of dictionary words. See following examples for more details.
 * This is a famous Google interview question, also being asked by many other companies now a days.
 * <p>
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 * cream, icecream, man, go, mango}
 * <p>
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 * <p>
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */
public class WordBreakProblem {
    private static final Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {

        // array of strings to be added in dictionary set.
        String[] temp_dictionary = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};

        // loop to add all strings in dictionary set
        Collections.addAll(dictionary, temp_dictionary);

        // sample input cases
        System.out.println(wordBreak("ilike"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
    }

    public static boolean wordBreak(String input) {
        return wordsBreak(input);
    }

    public static boolean wordsBreak(String input) {
        if (input.length() == 0) {
            return true;
        }
        for (int i = 1; i <= input.length(); i++) {
            String word = input.substring(0, i);
            if (dictionary.contains(word) && wordBreak(input.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
