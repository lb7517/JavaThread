package rlock;

public class ThreadTest {
    public static void main(String args[]){
        Lock lock = new Lock();
        ReadLock readLock = new ReadLock(lock);

        ThreadA ta = new ThreadA(readLock);
        Thread t1 = new Thread(ta, "t1");

        t1.start();
    }
}
