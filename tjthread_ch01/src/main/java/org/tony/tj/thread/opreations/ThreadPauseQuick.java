package org.tony.tj.thread.opreations;

/***
 * 暂停一个线程 暂停可以使用Thread.sleep()方法
 * 停止一个线程 停止使用Thread.stop()方法,但是不建议使用stop方法，因为已经过时了
 * 因为线程在执行期间可以访问的所有Java对象都将处于未知状态。
 * 如果应用程序中的其他线程也可以访问相同的对象，那么应用程序可能会意外地、不可预测地失败
 * 我们可以自己创建一个方法，进行停止线程
 */
public class ThreadPauseQuick {

    public static void main(String... args) {
        Thread threadSleep = new Thread() {
            public void run() {
                System.out.println("test sleep thread");
            }
        };
        try {
            // 暂停线程，传入一个number参数，代表暂停的时间 以毫秒为单位
            // 调用native方法 public static native void sleep(long millis) throws InterruptedException;
            threadSleep.sleep(10L * 1000L);
            threadSleep.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //利用Runnable的doStop标记停止线程
        MyDoStopRunnable myDoStopRunnable = new MyDoStopRunnable();
        Thread threadStop = new Thread(myDoStopRunnable);
        threadStop.start();
        myDoStopRunnable.doStop();
        
    }
    
}