package org.tony.tj.thread.raceconditionscriticalsections;

/**
 * 在同一个应用程序中运行多个线程本身不会导致问题。
 * 当多个线程访问相同的资源时，问题就出现了。
 * 例如相同的内存(变量、数组或对象)、系统(数据库、web服务等)或文件。
   事实上，只有在一个或多个线程写入这些资源时才会出现问题。
   只要资源不改变，让多个线程读取相同的资源是安全的。
 */
public class RaceConditionQuick {
    
    public static void main(String ... args){
        //当使用多个线程去调用timer类中的add修改timer的时候，将会出现竞争关系
        //不一定会出现想要的情况，add()方法中的代码不会作为单个原子指令由Java虚拟机执行。
        //相反，它是作为一组较小的指令执行的
        //操作流程：读取this.timer到内存中 2.添加值  3.将值写入this.timer内存中
        //但是在进行将添加修改值的时候，多线程会出现竞争关系
        /**
         * timer初始化为0
         * 
         * thread01 -> add(2) -> 2
         * thread02 -> add(3) -> 3
         * 这两个线程希望将值2和3添加到计数器中。
         * 因此，在两个线程完成执行后，值应该是5。
         * 但是，由于这两个线程的执行是交错的，所以最终的结果是不同的
         */
        Timer timer = new Timer();
        new Thread(new RaceConditionQuickRunnable(timer, 2)).start();
        new Thread(new RaceConditionQuickRunnable(timer, 3)).start();

        ResoveTimerReceCondition receCondition = new ResoveTimerReceCondition();
        new Thread(new Runnable(){
            @Override
            public void run() {
                receCondition.add(2);
            }
        }).start();

        new Thread(new Runnable(){
        
            @Override
            public void run() {
                receCondition.add(3);
            }
        }).start();
        System.out.println("resove timer:" + receCondition.timer.get());
    }
}