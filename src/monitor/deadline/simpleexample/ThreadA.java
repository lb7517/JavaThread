package monitor.deadline.simpleexample;

public class ThreadA implements Runnable {

    private Lock lock;

    ThreadA(){}

    ThreadA(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            this.lock.lock();
            System.out.println("执行线程: "+Thread.currentThread().getName());
            Thread.sleep(3000);
            this.lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
