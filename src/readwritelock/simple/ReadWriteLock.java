package readwritelock.simple;

public class ReadWriteLock {

    private int readers = 0;

    private int writers = 0;

    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException {
        if(writeRequests > 0 || writers > 0){
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
        if(readers > 0 || writers > 0){
            wait();
        }
        writeRequests--;
        writers++;
        System.out.println("当前写数: "+writers);
    }

    public synchronized void unlockWrite(){
        writers--;
        notifyAll();
    }

}
