package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A : "+Thread.currentThread().getPriority());
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("B : "+Thread.currentThread().getPriority());
            }
        });
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("t1 priority: " + t1.getPriority());
        System.out.println("t2 priority: " + t2.getPriority());
    }
}