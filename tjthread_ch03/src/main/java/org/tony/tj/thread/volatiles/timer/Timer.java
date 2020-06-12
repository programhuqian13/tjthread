package org.tony.tj.thread.volatiles.timer;

public class Timer {

    private volatile int count;

    public Timer(int timer){
        this.count = timer;
    }

    public void add(int value){
        this.count += value;
    }
    
}