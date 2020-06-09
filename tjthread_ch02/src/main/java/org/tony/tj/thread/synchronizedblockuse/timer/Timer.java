package org.tony.tj.thread.synchronizedblockuse.timer;

/**
 * 进行计数，进行使用同步方法，只能让一个线程去进行操作
 */
public class Timer {

    long timer;

    /**
     * 定义一个同步的方法
     */
    public synchronized void add(long value){
        this.timer += value;
    }
}