package com.ita.thread.callbackandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Random random = new Random();
        int duration = random.nextInt(4000);

        Future<Integer> future = executor.submit(() -> {
            System.out.println("starting...");

            if(duration > 2000){
                throw new IOException("sleeping too long...");
            }

                  try {
                      Thread.sleep(duration);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("Finished.");

                  return duration;
        });

        executor.shutdown();
        try {
            System.out.println("Future is: "+future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
