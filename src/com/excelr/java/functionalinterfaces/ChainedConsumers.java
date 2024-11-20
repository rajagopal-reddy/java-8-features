package com.excelr.java.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ChainedConsumers {
    public static void main(String[] args) {
        List<String> names = List.of("john","anna","bob","jimmy","brown","max","cult");

        Consumer<String> print = name -> System.out.println(name.toUpperCase());

        Consumer<String> append = name -> System.out.println(name + " - Processed");

        Consumer<String> chain = print.andThen(append);

        System.out.println("Chained Consumer: ");
        names.forEach(chain);

    }
}
