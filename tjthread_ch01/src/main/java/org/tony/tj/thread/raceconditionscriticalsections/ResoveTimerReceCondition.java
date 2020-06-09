package org.tony.tj.thread.raceconditionscriticalsections;

import java.util.concurrent.atomic.AtomicLong;

public class ResoveTimerReceCondition {

    //定义一个原子类进行原子操作，避免线程在临界区进行竞争
    protected AtomicLong timer = new AtomicLong();

    protected long timer1;

    public long add(long value){
        return this.timer.addAndGet(value);
    }
    /**
     * 使用同步的方式执行add，避免发生临界区进行竞争
     * @param value
     */
    public synchronized void addTimer1(long value){
        this.timer1 += value;
    }
    
}