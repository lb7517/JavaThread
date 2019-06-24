package fairlock;

public class ThreadA implements Runnable {

    Synchronizer synchronizer;

    ThreadA(Synchronizer synchronizer){
        this.synchronizer = synchronizer;
    }
    @Override
    public void run() {
        try {
            synchronizer.doSynchronized();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
