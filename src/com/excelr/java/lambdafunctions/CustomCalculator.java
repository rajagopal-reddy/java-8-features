package com.excelr.java.lambdafunctions;

interface Calculator{
    int calculate(int a, int b);
}

public class CustomCalculator {
    public static void main(String[] args) {

        Calculator add = Integer::sum;

        Calculator sub = (a, b) -> a - b;

        Calculator mul = (a, b) -> a * b;

        Calculator div = (a, b) -> a / b;

        Calculator mod = (a, b) -> a % b;

        int a = 80;
        int b = 70;

        System.out.println(add.calculate(a,b));
        System.out.println(sub.calculate(a,b));
        System.out.println(mul.calculate(a,b));
        System.out.println(div.calculate(a,b));
        System.out.println(mod.calculate(a,b));

    }
}