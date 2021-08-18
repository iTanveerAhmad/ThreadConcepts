package com.ita.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Connection.getInstance().doConnect();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 200; i++){

            executorService.submit(()  -> {
                try {
                    Connection.getInstance().doConnect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);



    }

}
