package org.tony.tj.thread.signaling;

/***
 * 要想连个线程相互通信，线程A和线程B需要引用相同的ThreadSignaling
 */
public class ThreadSignaling {

    protected Integer counts = 0;

    public synchronized Integer getCounts(){
        return this.counts;
    }

    public synchronized void setCounts(Integer counts){
        this.counts = counts;
    }
    
}