package com.ita.thread.lowlevelsync;


public class App {

    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();

        Thread t1 = new Thread( () -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } );

        Thread t2 = new Thread( () -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } );

        t1.start();
        t2.start();

        t1.join();
        t1.join();

    }

}
