package com.excelr.java.anonymousclasses;

public class RunnableAnonymous {
    public static void main(String[] args) {

        Runnable runnableAnonymous = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Anonymous : " + i);
                }
            }
        };

        Runnable runnableLambda = () -> {
            for (int i = 1; i <= 5 ; i++){
                System.out.println("Lambda : " + i);
            }
        };

        new Thread(runnableAnonymous).start();
        new Thread(runnableLambda).start();
    }
}