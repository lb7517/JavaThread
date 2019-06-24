package monitor.deadline.simpleexample;

//管程死锁例子
public class Lock {

    private MonitorObject mo = new MonitorObject();

    private boolean isLocked = false;

    public void lock() throws InterruptedException {
        synchronized (this){ //todo 注释这个同步快即可执行正常
            while (isLocked){
                synchronized (this.mo){
                    this.mo.wait();
                }
            }
            isLocked = true;
        }
    }

    public void unlock(){
        synchronized (this){    //todo 注释这个同步快即可执行正常
            this.isLocked = false;
            synchronized (this.mo){
                this.mo.notify();
            }
        }
    }
}
