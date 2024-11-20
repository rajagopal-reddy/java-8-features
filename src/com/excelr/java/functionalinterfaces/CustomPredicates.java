package com.excelr.java.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;

public class CustomPredicates {
    public static void main(String[] args) {

        List<Integer> num = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> isEven = n -> n % 2 == 0;

        List<Integer> evenNum = num.stream()
                .filter(isEven)
                .toList();
        System.out.println("Even numbers: ");
        evenNum.forEach(System.out::println);

        List<String> words = List.of("ball", "bat", "pen", "book", "dog", "cat", "apple", "avocado");

        char letter = 'a';
        Predicate<String> startLetter = l -> l.startsWith(String.valueOf(letter));

        List<String> filterItem = words.stream()
                .filter(startLetter)
                .toList();

        System.out.println("Letters starting with 'a' : ");
        filterItem.forEach(System.out::println);
    }
}