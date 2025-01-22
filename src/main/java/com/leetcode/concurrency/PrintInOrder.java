package com.leetcode.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintInOrder {

    Semaphore second;
    Semaphore third;

    public PrintInOrder() {
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                printInOrder.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.close();
    }
}
