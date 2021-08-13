package com.ita.thread.creation;


class Runner2 implements Runnable{

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

public class ThreadCreation2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner2());
        Thread thread2 = new Thread(new Runner2());

        thread1.start();
        thread2.start();

    }

}
