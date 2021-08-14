package com.ita.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private final int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting:"+id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed:"+id);
    }
}

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++){
            service.submit(new Processor(i));
        }

        service.shutdown();

        System.out.println("All task submitted!");

        try {
           boolean result =  service.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("awaitTermination: "+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All task are completed!");


    }

}
