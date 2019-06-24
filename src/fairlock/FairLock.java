package fairlock;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock(){
        String threadName = Thread.currentThread().getName();
        QueueObject queueObject = new QueueObject(threadName);
        boolean isLockedForThisThread = true;
        synchronized (this){
            waitingThreads.add(queueObject);
        }
        while (isLockedForThisThread){
            synchronized (this){
                isLockedForThisThread = isLocked || (waitingThreads.get(0) != queueObject);
                if(!isLockedForThisThread){
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                System.out.println("------等待----");
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this){
                    waitingThreads.remove(queueObject);
                }
                e.printStackTrace();
            }
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if(waitingThreads.size() > 0){
                waitingThreads.get(0).doNotify();
        }
    }

}
