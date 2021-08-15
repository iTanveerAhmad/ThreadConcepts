package com.ita.thread.waitAndNotify;

import java.util.Scanner;

public class Processor {

    public void producer() throws InterruptedException {

        synchronized (this){
            System.out.println("Producer thread running...");

            wait();

            System.out.println("Resumed!");
        }
    }

    public void consumer() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("waiting for return key...");
            scanner.nextLine();
            System.out.println("return key passed!");
            notify();

        }

    }

}
