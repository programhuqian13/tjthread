package org.tony.tj.thread;

class ThreadQuickStartOne{
    public static void main(String ... args){
        //创建一个线程使用thread
        // Thread thread = new Thread(); 
        // Thread类默认是实现了Runnable,只是需要实现run接口就可以了
        //这个线程没有指定任何的运行代码
        //有两种方法去指定执行的代码，一个是创建一个子类，继承thread，重写run方法
        //一个是实现Runnable接口，创建一个线程，将这个接口传入thread中
        Thread threadRItf = new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("create an anonymous subclass");
            }
        });
        Thread threadItf = new Thread(new ThreadRunnableImpl());
        Thread subClassImp = new ThreadSubClassImpl();
        //使用lambda实现一个runnable接口
        Runnable runnable = () -> {
            System.out.println("use lambda impl runnable");
        };
        Thread threadLabRun = new Thread(runnable);
        //启动一个线程
        threadRItf.start();
        threadItf.start();
        subClassImp.start();
        threadLabRun.start();
    }
}