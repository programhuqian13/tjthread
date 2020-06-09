package org.tony.tj.thread.opreations;

/***
 * 注意doStop()和keepRunning()方法。
 * doStop()将从执行MyDoStopRunnable的run()方法的线程之外的其他线程调用。
 * keepRunning()方法由执行MyDoStopRunnable的run()方法的线程在内部调用。
 * 只要没有调用doStop()， keepRunning()方法就会返回true—意味着执行run()方法的线程将继续运行。
 */
public class MyDoStopRunnable implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    public synchronized boolean keepRunning() {
        return this.doStop;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (keepRunning()) {
            System.out.println("Running...");
            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}