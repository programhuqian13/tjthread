package org.tony.tj.thread.signaling;

/**
 * 使用自旋锁解决虚假唤醒的问题 为了防止虚假唤醒，信号成员变量在while循环中而不是在if语句中检查。 这样的while循环也称为自旋锁。
 */
public class ThreadWaitNotifyUpdate2 {

    MyObject myObject = new MyObject();
    boolean wasSignalled = false;

    public void doWait() {
        synchronized (myObject) {
            while (!wasSignalled) {
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
    
    class MyObject {

    }
}