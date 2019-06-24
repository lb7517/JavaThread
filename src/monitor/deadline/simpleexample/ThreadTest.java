package monitor.deadline.simpleexample;

public class ThreadTest {
    public static void main(String args[]){
        Lock lock = new Lock();
        ThreadA ta = new ThreadA(lock);
        Thread t1 = new Thread(ta, "t1");
        Thread t2 = new Thread(ta, "t2");
        System.out.println("=");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
