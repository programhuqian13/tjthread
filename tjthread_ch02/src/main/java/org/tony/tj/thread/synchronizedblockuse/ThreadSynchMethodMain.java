package org.tony.tj.thread.synchronizedblockuse;

import org.tony.tj.thread.synchronizedblockuse.timer.Timer;

public class ThreadSynchMethodMain {

    public static void main(String ... args){
        Timer timer = new Timer();
        Thread thread01 = new ThreadSynchMethod(timer);
        Thread thread02 = new ThreadSynchMethod(timer);

        thread01.start();
        thread02.start();
    }
}