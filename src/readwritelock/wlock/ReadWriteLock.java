package readwritelock.wlock;

import java.util.HashMap;
import java.util.Map;

//写锁可重入
public class ReadWriteLock {

    private int readers = 0;

    private int writeAccess = 0;

    private int writeRequests = 0;

    private Map<Thread, Integer> readingThreads = new HashMap<>(); //新增

    private Thread writingThread = null;

    public synchronized void lockRead() throws InterruptedException {
        if(writeRequests > 0 || writeAccess > 0){
            wait();
        }
        readers++;
        System.out.println("当前读数: "+readers);
    }

    public synchronized void unlockRead(){
        readers--;
//        notify();   //不用此的原因是，可以同时唤醒多个读而不是一个一个
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;   //请求写可以有多个
        Thread callingThread = Thread.currentThread();
        if(!canGrantWriteAccess(callingThread)){
            wait();
        }
        writeRequests--;
        writeAccess++;
        writingThread = callingThread;
        System.out.println("当前写数: "+writeAccess);
    }

    public synchronized void unlockWrite(){
        writeAccess--;
        if(writeAccess == 0){
            writingThread = null;
        }
        notifyAll();
    }

    public boolean canGrantWriteAccess(Thread callingThread){
        if(hasReader()){
            return false;
        }
        if(writingThread == null){
            return true;
        }
        if(!isWriter(callingThread)){ //不同线程写，要阻塞
            return false;
        }
        return true;
    }

    public boolean hasReader(){
        return readingThreads.size() > 0;
    }

    public boolean isWriter(Thread callingThread){
        return writingThread == callingThread;
    }
}
