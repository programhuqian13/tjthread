package org.tony.tj.thread.threadlocal;

import java.util.function.Supplier;

/***
 * Java ThreadLocal类允许您创建只能由同一线程读写的变量。
 * 因此，即使两个线程执行相同的代码，并且代码引用相同的ThreadLocal变量，
 * 两个线程也不能看到彼此的ThreadLocal变量。
 * 因此，Java ThreadLocal类提供了一种使代码线程安全的简单方法。
 * 创建ThreadLocal实例就像创建任何其他Java对象一样——通过new操作符
 */
public class ThreadLocalQuick {
    
    public static void main(String ... args){
        /**
         * 每个线程只需要执行一次。多个线程现在可以在这个ThreadLocal中获取和设置值，
         * 并且每个线程只能看到它自己设置的值
         * 获取threadLocal中的值，使用get方法
         * 移除threadLocal中的值，使用remove方法
         * 
         */
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello ThreadLocal");
        String threadLocalValue = threadLocal.get();
        System.out.println("main thread threadLocalValue:" + threadLocalValue);

        /***
         * 给ThreadLocal设置初始值，可以为Java ThreadLocal设置一个初始值，
         * 该值将在首次调用get()时使用-在以新值调用set()之前
         * 1.使用覆盖initialValue方法进行初始化（创建一个ThreadLocal的子类）
         * 2.创建一个ThreadLocal实现Supplier接口
         */
        //使用initialValue初始化ThreadLocal的值
        ThreadLocal<String> threadLocalInit = new ThreadLocal<String>(){
            
            @Override
            protected String initialValue() {
                return String.valueOf(System.currentTimeMillis());
            }
        };

        System.out.println("threadLocalInit:" + threadLocalInit.get());

        ThreadLocal<String> threadLocalInit2 = ThreadLocal.withInitial(new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf(System.currentTimeMillis());
            }
        });
        
        System.out.println("threadLocalInitSupplier:" + threadLocalInit2.get());

        //因为Supplier是一个函数接口，所以可以使用Java Lambda表达式实现
        ThreadLocal<String> threadLocalInit3 = ThreadLocal.withInitial(
            ()->{return String.valueOf(System.currentTimeMillis());});

        System.out.println("threadLocalInitLambda:" + threadLocalInit3.get());

        ThreadLocal<String> threadLocalInit4 = ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));
        System.out.println("threadLocalInitLambda:" + threadLocalInit4.get());
    }

}