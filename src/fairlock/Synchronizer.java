package fairlock;

public class Synchronizer {
    FairLock lock;
    Synchronizer(FairLock lock){
        this.lock = lock;
    }
    public void doSynchronized() throws InterruptedException {
        this.lock.lock();
        System.out.println(Thread.currentThread().getName()+": 执行同步模块");
        Thread.currentThread().sleep(2000);
        this.lock.unlock();
    }
}
