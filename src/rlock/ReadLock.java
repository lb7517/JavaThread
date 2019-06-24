package rlock;

public class ReadLock {

    Lock lock;

    ReadLock(){}

    ReadLock(Lock lock){
        this.lock = lock;
    }

    public void readLock(){
        try {
            this.lock.lock();
            this.lock.lock();// 第二次读取还是可以的，里面实现了可重入锁
            System.out.println("执行线程: "+Thread.currentThread().getName());
            this.lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
