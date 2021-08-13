package com.ita.thread.creation;

public class ThreadCreation3 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

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
        });

        thread.start();
    }

}
