package com.ita.thread.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // follow FIFO , also thread-safe

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread( () -> {  producer();  } );

        Thread t2 = new Thread( () -> {  consumer();  } );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    private static void producer() {
        Random random = new Random();
        while (true){
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {

        Random random = new Random();
        while (true){

            try {
            Thread.sleep(100);

                if(random.nextInt(10) == 0){
                        int value = queue.take();
                        System.out.println("taken value: "+value+"; queue size: "+queue.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
