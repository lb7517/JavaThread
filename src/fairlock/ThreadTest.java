package fairlock;

public class ThreadTest {
    public static void main(String args[]){
        FairLock lock = new FairLock();
        Synchronizer synchronizer = new Synchronizer(lock);
        ThreadA ta = new ThreadA(synchronizer);
        ThreadB tb = new ThreadB(synchronizer);

        Thread t1 = new Thread(ta, "threadA1");
        Thread t2 = new Thread(tb, "threadB1");
        Thread t3 = new Thread(ta, "threadA2");
        Thread t4 = new Thread(tb, "threadB2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        java.lang.Thread.State sl;
    }
}
