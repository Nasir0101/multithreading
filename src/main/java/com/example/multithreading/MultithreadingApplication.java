package com.example.multithreading;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingApplication {

    public static void main(String[] args) throws IOException {

        MultithreadingApplication.getExecutionTimeWithOutMultiThreading();
        MultithreadingApplication.getExecutionTimeByMultiThreading();


    }


    public static void getExecutionTimeWithOutMultiThreading() throws IOException {
        long startTimeAfter = System.currentTimeMillis();
        NonThreadClass object = new NonThreadClass();
        String obj1 = object.mygetRequest();
        System.out.println(obj1);
        String obj2 = object.mygetRequest();
        System.out.println(obj2);
        String obj3 = object.mygetRequest();
        System.out.println(obj3);
        long endTimeAfter = System.currentTimeMillis();
        float afterSec = (endTimeAfter - startTimeAfter) / 1000F;
        System.out.println(afterSec + " Time taken WithOut MultiThreading in seconds");
    }


    public static void getExecutionTimeByMultiThreading() {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Runnable thread = new ThreadingClass();
            executor.execute(thread);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000F;
        System.out.println(sec + " Time taken By MultiThreading Processing in seconds");
    }
}
