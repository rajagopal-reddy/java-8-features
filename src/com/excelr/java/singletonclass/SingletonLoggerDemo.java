package com.excelr.java.singletonclass;

class Logger {

    private static Logger instance;
    private Logger() {
    }

    public static synchronized Logger getInstance(){
        if(instance==null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        System.out.println(Thread.currentThread().getName() + " - " + message);
    }
}

public class SingletonLoggerDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            Logger logger = Logger.getInstance();
            logger.log("Logging a message");
        };

        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
