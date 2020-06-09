package org.tony.tj.thread.raceconditionscriticalsections;

public class RaceConditionQuickRunnable implements Runnable{

    Timer timer = null;
    long value = 0;

    public RaceConditionQuickRunnable(Timer timer,long value){
        this.timer = timer;
        this.value = value;
    }

    @Override
    public void run() {
       this.timer.add(value);
    }
    
}