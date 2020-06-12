package org.tony.tj.thread.volatiles;

import org.tony.tj.thread.volatiles.timer.Timer;

/***
 * Volatile关键字讲解
 * java Volatile关键字用于将java变量标记为“存储在主内存中”
 * 意味着对volatile变量的每次读取都将从计算机的主存中读取，而不是从CPU的缓存中读取。而且
 * 对volatile变量的每次写入都将写入主存，而不仅仅是写入CPU缓存中。
 * volatile作用在变量上
 */
public class ThreadVolatileQuick {

    public static void main(String ... args){
        
        Timer t = new Timer(0);

        Thread thread01 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                t.add(1);
            }
        });

        Thread thread02 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                t.add(1);
            }
        });

        thread01.start();
        thread02.start();
    }
}