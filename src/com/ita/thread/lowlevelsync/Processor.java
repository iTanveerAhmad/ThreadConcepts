package com.ita.thread.lowlevelsync;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    Object lock = new Object();

    public void producer() throws InterruptedException {

        int value = 0;
        while (true) {
            synchronized (lock){
                while (list.size() == LIMIT){
                    lock.wait();
                }

            }
            list.add(value++);

        }

    }

    public void consumer() throws InterruptedException {

        Random random = new Random();

        while (true){
            synchronized (lock){

                while (list.size() == 0){
                    lock.notify();
                }
                System.out.print("list size: "+list.size());
                int value  = list.removeFirst();
                System.out.println("; value is: "+value);
                lock.notify();

            }
            Thread.sleep(random.nextInt(1000));

        }

    }
}
