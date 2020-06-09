package org.tony.tj.thread.opreations;

//给线程指定相应的线程名，在有多个线程的情况下，使用比较好
public class ThreadNameQuick {
    public static void main(String ... args){
        //调用thread的构造函数
        //new Thread(String name){ init(null, null, name, 0);}
        Thread myThread = new Thread("my_thread01"){
            public void run(){
                System.out.println("run by:" + getName());
            }
        };

        myThread.start();
        System.out.println(myThread.getName());
        //通过进行runnable进行指定
        //调用thread的另外一个构造函数
        //new Thread(Runnable runnable,String name){init(null, runnable, name, 0);}
        Thread myRunThread = new Thread(new Runnable(){
            //由于runnable不是thread的子类，因此不能使用getName方法，只能在外部使用
            @Override
            public void run() {
                System.out.println("run by:runnable");
            }
        },"my_thread02");
        myRunThread.start();
        System.out.println(myRunThread.getName());

        //获取当前的线程
        //currentThread()方法返回对执行currentThread()的线程实例的引用。
        //通过这种方式，你可以访问表示执行给定代码块的线程的Java线程对象。
        //当前是调用java的native方法进行操作
        Thread threadCurrent = Thread.currentThread();
        System.out.println(threadCurrent.getName());
        //一旦有了对Thread对象的引用，就可以对其调用方法
        //下面的线程的执行过程不是顺序执行的，那个线程先抢占到资源，那个线程就运行
        //因为线程原则上是并行执行的，而不是顺序执行的
        for(int i = 0; i < 10 ;i++){
            new Thread("mythread" + i){
                public void run(){
                    System.out.println("run thread name:" + getName());
                }
            }.start();
        }
    }

}