package threadcreated;

public class ThreadTest {
    public static void main(String args[]){

        Counter counter = new Counter();
        System.out.println("1: "+counter.getCount());

        //方式一 Runnable
        RunnableImpl runnableImpl = new RunnableImpl(counter);
        Thread t1 = new Thread(runnableImpl, "runnable");
        t1.start();
        //t1.run() //错误
        System.out.println("runnable: "+t1.getName());

        //方式二 Thread
        ThreadExtends et = new ThreadExtends(counter);
        et.start();
        et.setName("Thread2");
        //或者通过如下获取名
//        Thread.currentThread().setName("Thread2");
        System.out.println("thread: "+et.getName());

        //方式三 匿名Thread
        Thread t3 = new Thread("thread3"){
            public void run(){
                System.out.println("匿名 thread 执行");
            }
        };
        t3.start();
        System.out.println("thread: "+t3.getName());


        //方式四 匿名Runnbale
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名 runnable 执行");
            }
        };
        Thread t4 = new Thread(r, "匿名Runnbale");
        t4.start();
        System.out.println("thread: "+t4.getName());
    }
}
