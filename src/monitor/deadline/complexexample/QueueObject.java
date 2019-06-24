package monitor.deadline.complexexample;

public class QueueObject {

    private boolean isNotified = false;

    private String threadName;

    QueueObject(){}

    QueueObject(String threadName){
        this.threadName = threadName;
    }

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified){
            wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify(){
        this.isNotified = true;
        this.notify();
    }
}
