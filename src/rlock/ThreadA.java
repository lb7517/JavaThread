package rlock;

public class ThreadA implements Runnable {

    private ReadLock readLock;

    ThreadA(){}

    ThreadA(ReadLock readLock){
        this.readLock = readLock;
    }

    @Override
    public void run() {
        this.readLock.readLock();
    }
}
