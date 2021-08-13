package com.ita.thread.creation;

/**
 * This is the one way of creating Threads
 */

class Runner1 extends Thread{

    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("thread:"+i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class ThreadCreation1 {

    public static void main(String[] args) {
        Runner1 thread1 = new Runner1();
        Runner1 thread2 = new Runner1();

        thread1.start();
        thread2.start();

    }


}
