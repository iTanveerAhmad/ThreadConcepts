package com.ita.thread.deadlock;

import java.security.PrivateKey;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    private void acquirelocks(Lock firstLock, Lock secondLock) throws InterruptedException {

        while (true){

            // acquire locks
            boolean gotFirstlock = false;
            boolean gotSecondlock = false;

            try{
                gotFirstlock = firstLock.tryLock();
                gotSecondlock = secondLock.tryLock();
            }
            finally {

                if(gotFirstlock && gotSecondlock){
                    return;
                }

                if(gotFirstlock){
                    firstLock.unlock();
                }

                if(gotSecondlock){
                    secondLock.unlock();
                }
            }



            //not acquire locks
            Thread.sleep(1);
        }

    }

    public void firstThread() throws InterruptedException {

        Random random = new Random();
        for(int i = 0; i < 10000; i++){

            acquirelocks(lock1, lock2);

            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally{
                lock1.unlock();
                lock2.unlock();
            }


        }


    }

    public void secondThread() throws InterruptedException {

        Random random = new Random();
        for(int i = 0; i < 10000; i++){

            acquirelocks(lock1, lock2);

            try {
                 Account.transfer(acc2, acc1, random.nextInt(100));
            }
            finally{
                lock1.unlock();
                lock2.unlock();
            }
        }

    }

    public void finished(){

        System.out.println("Account 1 balance: "+acc1.getBalance());
        System.out.println("Account 2 balance: "+acc2.getBalance());
        System.out.println("Total balance: "+ (acc1.getBalance() + acc2.getBalance()));

    }

}
