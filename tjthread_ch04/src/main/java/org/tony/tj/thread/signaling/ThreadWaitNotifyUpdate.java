package org.tony.tj.thread.signaling;

/**
 * ThreadWaitNotify 出现的问题 如果一个线程在要发送信号的线程调用wait()之前调用了notify()， 那么等待的线程将错过这个信号。
 * 但在某些情况下，这可能导致等待的线程永远等待，永远不会被唤醒，因为唤醒信号被错过了。 ThreadWaitNotifyUpdate 解决上面的问题
 * 记录相关标记在成员变量中进行处理
 * 这里会出现一个问题：虚假唤醒，在没有调用notify或者notifyAll的时候，线程被唤醒了。并且无理由唤醒。
 * 使用自旋锁可以解决，ThreadWaitNotifyUpdate2
 */
public class ThreadWaitNotifyUpdate {

    MyObject myObject = new MyObject();
    boolean wasSignalled = false;

    public void doWait() {
        synchronized (myObject) {
            if (!wasSignalled) {
                try {
                    myObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized(myObject){
            wasSignalled = true;
            myObject.notify();
        }
    }

    class MyObject{}

    
}