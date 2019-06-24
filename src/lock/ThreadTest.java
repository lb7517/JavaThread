package lock;

public class ThreadTest {
    public static void main(String args[]){
        Lock lock = new Lock();
        Synchronizer synchronizer = new Synchronizer(lock);
        ThreadA ta = new ThreadA(synchronizer);
        ThreadB tb = new ThreadB(synchronizer);

        System.out.println("---");
        Thread t1 = new Thread(ta, "threadA");
        Thread t2 = new Thread(tb, "threadB");
        t1.start();
        t2.start();
    }
}
