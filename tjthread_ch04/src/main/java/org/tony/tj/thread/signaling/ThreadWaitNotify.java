package org.tony.tj.thread.signaling;

/**
 * 这里有问题
 * 如果一个线程在要发送信号的线程调用wait()之前调用了notify()，
 * 那么等待的线程将错过这个信号。
 * 但在某些情况下，这可能导致等待的线程永远等待，永远不会被唤醒，因为唤醒信号被错过了。
 */
public class ThreadWaitNotify {

    MyObject myObject = new MyObject();

    public void doWait() {
        synchronized (myObject) {
            try {
                myObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized(myObject){
            myObject.notify();
        }
    }

    class MyObject{

    }
    
}