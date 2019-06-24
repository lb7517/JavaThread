package monitor.deadline.complexexample;

public class ThreadTest {
    public static void main(String args[]){
        FairLock lock = new FairLock();
        Synchronizer synchronizer = new Synchronizer(lock);
        ThreadA ta = new ThreadA(synchronizer);

        Thread t1 = new Thread(ta, "t1");
        Thread t2 = new Thread(ta, "t2");

        t1.start();
        t2.start();

        System.out.println("----------");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完");
    }
}
