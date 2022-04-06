package com.demo.assessment.Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A precedence rule is given as "P>E", which means that letter "P" is followed directly by the letter "E".
 * *  Write a function, given an array of precedence rules, that finds the word represented by the given rules.
 * <p>
 * Note: Each represented word contains a set of unique characters, i.e. the word does not contain duplicate letters.
 * <p>
 * Examples:
 * findWord(["P>E","E>R","R>U"]) // PERU
 * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
 */
public class PrecedenceRule {
    public static void main(String[] args) {

        String result = findWord(List.of("P>E", "E>R", "R>U")); // PERU
        System.out.println(result);
        result = findWord(List.of("I>N", "A>I", "P>A", "S>P")); // SPAIN
        System.out.println(result);
    }

    public static String findWord(List<String> list) {
        Map<String, String> map = new HashMap<>();

        for (String value : list) {
            String[] s = value.split(">");
            map.put(s[0], s[1]);
        }

        String result;
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).split(">");
            String key = s[0];
            String value = s[1];
            result = key + value;
            int count = 0;
            while (true) {
                if (count == list.size() - 1) {
                    return result;
                }
                String mapValue = map.get(value);
                if (mapValue == null) {
                    break;
                }
                result += mapValue;
                count++;
                value = mapValue;
            }
        }
        return null;
    }
}