package monitor.deadline.complexexample;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock(){
        String threadName = Thread.currentThread().getName();
        QueueObject queueObject = new QueueObject(threadName);
        synchronized (this) {
            waitingThreads.add(queueObject);
            System.out.println("lock: "+Thread.currentThread().getName());
            while (isLocked || (waitingThreads.get(0) != queueObject)){
                synchronized (queueObject){
                    try {
                        System.out.println("isLocked: "+isLocked);
                        System.out.println("------等待----: "+Thread.currentThread().getName());
                        queueObject.doWait();
                    } catch (InterruptedException e) {
                        waitingThreads.remove(queueObject);
                    }
                }
            }
            waitingThreads.remove(queueObject);
            isLocked = true;
            lockingThread = Thread.currentThread();
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if(waitingThreads.size() > 0){
            QueueObject queueObject = waitingThreads.get(0);
            synchronized (queueObject){
                queueObject.doNotify();
            }
        }
    }

}
