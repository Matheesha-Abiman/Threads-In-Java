package com.example;

public class ExtentThreadClass {
    public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}