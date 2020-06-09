package org.tony.tj.thread.raceconditionscriticalsections;

/**
 * 记录次数
 */
public class Timer{

    protected long timer;

    public void add(long value){
        this.timer += value;
        System.out.println(this.timer);
    }

}
