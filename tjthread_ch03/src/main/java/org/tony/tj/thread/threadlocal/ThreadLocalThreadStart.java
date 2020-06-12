package org.tony.tj.thread.threadlocal;

public class ThreadLocalThreadStart {

    public static void main(String ... args) throws InterruptedException {
        ThreadLocalRunnable threadLocalRunnable = new ThreadLocalRunnable();
        
        Thread thread01 = new Thread(threadLocalRunnable);
        Thread thread02 = new Thread(threadLocalRunnable);

        thread01.start();
        thread02.start();

        thread01.join();  //等待线程1终止
        thread02.join();  //等待线程2终止
    }
    
}