package blockqueue;

public class ThreadA implements Runnable {

    BlockingQueue blockingQueue;

    Car car;

    ThreadA(BlockingQueue blockingQueue, Car car){
        this.blockingQueue = blockingQueue;
        this.car = car;
    }

    @Override
    public void run() {
        try {
//            blockingQueue.enqueue(car);
            Car car1 = blockingQueue.dequeue();
            System.out.println("线程: "+ Thread.currentThread().getName()+" , car1: "+car1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
