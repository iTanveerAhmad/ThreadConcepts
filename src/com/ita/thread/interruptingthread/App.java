package com.ita.thread.interruptingthread;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting...");
        Thread thread = new Thread(() -> {

            Random random = new Random();
            for(int i = 0; i < 1E5; i++){

                // use this check to deducted the thread, either its been interrupted or not
//                if(Thread.currentThread().isInterrupted()){
//                    System.out.println("Interrupted.");
//                    break;
//                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                    break;
                }
                Math.sin(random.nextDouble());
            }



        });

        thread.start();

        Thread.sleep(500);
        thread.interrupt();

        thread.join();

        System.out.println("Finished.");

    }

}
