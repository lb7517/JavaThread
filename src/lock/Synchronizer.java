package lock;

public class Synchronizer {

    Lock lock;

    Synchronizer(Lock lock){
        this.lock = lock;
    }

    public void doSynchronized() throws InterruptedException {
        this.lock.lock();
        System.out.println("执行同步模块");
        Thread.currentThread().sleep(2000);
        this.lock.unlock();
    }
}
