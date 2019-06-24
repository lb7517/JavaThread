package fairlock;

public class ThreadB implements Runnable {

    Synchronizer synchronizer;

    ThreadB(Synchronizer synchronizer){
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
