package com.excelr.java.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnalyzeSentence {
    public static void main(String[] args) {
        String s = "Hello World ! John has a dog names Jimmy , John and Jimmy went to a garden";

        long countWords = Arrays.stream(s.trim().split(" ")).count();

        System.out.println("Number of words: " + countWords);

        System.out.println("----------------------");


        String longestWord = Arrays.stream(s.trim().split(" "))
                .max(Comparator.comparing(String::length))
                .orElse("no words found");

        System.out.println("First longest word: " + longestWord);

        System.out.println("----------------------");

        List<String> sorted = Arrays.stream(s.trim().split(" "))
                .map(String::toLowerCase)
                .sorted()
                .toList();

        System.out.println("Words in alphabetical order: ");
        sorted.forEach(System.out::println);

    }
}
