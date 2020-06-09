/**
 * thread中的同步关键字的使用
 * Java同步块将方法或代码块标记为同步的。
 * Java中的同步块一次只能在一个线程中执行。
 * 因此，可以使用Java同步块来避免竞争条件。
 * 同步机制是Java的第一个用于同步访问由多个线程共享的对象的机制
 * Java中的同步块用Synchronized关键字标记。
 * Java中的同步块在某些对象上是同步的。
 * 在同一对象上同步的所有同步块只能有一个线程同时在其中执行。
 * 所有其他试图进入同步块的线程都将被阻塞，直到同步块中的线程退出该块
 * 
 * 同步关键字可以用来标记4中不同当时的代码块：
 * 1.实例方法
 *     public synchronized void add(int value){}
 * 2.静态方法
 *     public synchronized static void add(int value){}
 * 3.实例方法中的代码块
 *     public void add(int value){
 *         synchronized(this) {
 *         }
 *     }
 * 4.静态方法中的代码块
 *     public static void add(int value){
 *         synchronized(this){
 *         }
 *     }
 */
package org.tony.tj.thread.synchronizedblockuse;
import java.util.function.Consumer;
public class ThreadSynchQuick {

    public static void main(String ... args){
        //在lambda表达式用使用同步块
        Consumer<String> func = (String params) -> {
            synchronized(ThreadSynchQuick.class){
                System.out.println(Thread.currentThread().getName() + " step 1:" + params);
                try{
                    Thread.sleep((long)(Math.random() * 1000));
                }catch (Exception e) {
                    //TODO: handle exception
                }
                System.out.println(Thread.currentThread().getName() + " step 2: " + params);
            }
        };

        Thread thread01 = new Thread(() -> {
            func.accept("Parameter");
        },"Thread_01");
    
        Thread thread02 = new Thread(() -> {
            func.accept("Parameter");
        },"Thread_02");
    
        thread01.start();
        thread02.start();
    }
    
}