package com.ita.thread.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

    public static Connection instance = new Connection();
    private int connection = 0;
    private Semaphore semaphore = new Semaphore(10, true); // 10 mean no of connection that we used
    //
    /* true mean
    Acquires a permit from this semaphore, blocking until one is available, or the thread is interrupted.
    Acquires a permit, if one is available and returns immediately, reducing the number of available permits by one
     */

    private Connection(){

    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect() throws InterruptedException {
        semaphore.acquire();

        try {
            doConnect();
        }
        finally {
            semaphore.release();
        }

    }

    public void doConnect() throws InterruptedException {

        synchronized (this){
            connection++;
            System.out.println("Current Connection: "+connection);
        }

        Thread.sleep(2000);

        synchronized (this){
            connection--;
        }

    }

}
