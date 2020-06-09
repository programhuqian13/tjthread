package org.tony.tj.thread.synchronizedblockuse;

import org.tony.tj.thread.synchronizedblockuse.timer.Timer;

public class ThreadSynchMethod extends Thread{

    protected Timer timer = null;

    ThreadSynchMethod(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        for(int i = 0 ;i < 10; i++){
            timer.add(i);
        }
    }

    
}