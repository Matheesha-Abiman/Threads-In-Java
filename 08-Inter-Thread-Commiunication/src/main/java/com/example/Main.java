package com.example;

public class Main {
    public static void main(String[] args) {
        A a = new A();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                a.put(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                a.get();
            }
        });

        t1.start();
        t2.start();
    }
}

class A {
    int num;
    boolean valueSet = false;

    synchronized void put(int num) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.num = num;
        System.out.println("put: " + num);
        valueSet = true;
        notify();
    }

    synchronized void get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get: " + num);
        valueSet = false;
        notify();
    }
}
