package rlock;

public class Lock {

    private boolean isLocked = false;

    private Thread lockedBy = null;

    private int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && callingThread != lockedBy){ //可重入条件
            this.wait();
        }
        lockedCount++;
        isLocked = true;
        lockedBy = callingThread;
        System.out.println("线程: "+Thread.currentThread().getName()+" 执行次数counter: "+lockedCount);
    }

    public synchronized void unlock(){
        if(lockedBy == Thread.currentThread()){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                this.notify();
            }
        }
    }
}
