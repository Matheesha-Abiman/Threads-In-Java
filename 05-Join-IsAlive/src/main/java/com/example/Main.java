package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //t2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();

        System.out.println("t1 is alive: " + t1.isAlive());
        System.out.println("t2 is alive: " + t2.isAlive());
        Thread.sleep(10);

        t2.start();

        System.out.println("t1 is alive: " + t1.isAlive());
        System.out.println("t2 is alive: " + t2.isAlive());

        t1.join();

        System.out.println("t1 is alive: " + t1.isAlive());
        System.out.println("t2 is alive: " + t2.isAlive());

        t2.join();

        System.out.println("t1 is alive: " + t1.isAlive());
        System.out.println("t2 is alive: " + t2.isAlive());
        System.out.println("Bye......");
    }
}