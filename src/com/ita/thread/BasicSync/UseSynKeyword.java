package com.ita.thread.BasicSync;

public class UseSynKeyword {

    private int count = 0;

    private synchronized void count(){
        count++;
    }

    public static void main(String[] args) {

        UseSynKeyword obj = new UseSynKeyword();
        obj.dowork();
    }

    private void dowork() {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    count();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    count();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(count);

    }

}
