package com.excelr.java.methodreferences;

import java.util.List;

/*
Reference Static and Instance Methods

Create a utility class with a static method convertToUpper(String s) and an instance method printWithPrefix(String s, String prefix).
Use method references to:
Convert a list of strings to uppercase.
Print each string with a prefix.
 */

class Utility{
    public static String convertToUpper(String s){
        return s.toUpperCase();
    }
    public static void printWithPrefix(String s, String prefix){
        System.out.println(prefix+s);
    }
}
public class ReferenceStatic {
    public static void main(String[] args) {

        List<String> names = List.of("Raju", "Angel", "Lena", "Yuki", "Momo");

        List<String> upper = names.stream()
                .map(Utility::convertToUpper)
                .toList();
        upper.forEach(System.out::println);

        String p = "Name: ";
        names.forEach(name -> Utility.printWithPrefix(name,p));
        
    }
}