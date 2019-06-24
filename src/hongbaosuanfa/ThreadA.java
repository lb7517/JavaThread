package hongbaosuanfa;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadA implements Runnable {

    ReentrantLock reentrantLock;
    List list;
    Entity entity;

    ThreadA(ReentrantLock reentrantLock, Entity entity){
        this.reentrantLock = reentrantLock;
        this.entity = entity;
    }

    public void run() {
        reentrantLock.lock();
        double a = Math.random()*entity.getTotalPrice();
        entity.getList().add(a);
        entity.setTotalPrice(entity.getTotalPrice() - a);
        reentrantLock.unlock();
    }
}
