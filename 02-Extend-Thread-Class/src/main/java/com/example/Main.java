package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        try {
            Thread.sleep(10); // Sleep for 100 milliseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a.start();
        b.start();
  }
}

class A extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A");
            try {
                Thread.sleep(1000); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B");
            try {
                Thread.sleep(1000); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}