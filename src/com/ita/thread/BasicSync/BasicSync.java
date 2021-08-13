package com.ita.thread.BasicSync;

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;

    public void run() {
        while(running){
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;

    }}

public class BasicSync {

    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop...");
        Scanner input = new Scanner(System.in);
        input.hasNext();

        proc1.shutdown();
    }

}
