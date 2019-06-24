package blockqueue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List<Car> queue = new LinkedList<>();

    private int limit = 10;

    BlockingQueue(int limit){
        this.limit = limit;
    }

    //入队
    public synchronized void enqueue(Car car) throws InterruptedException {
        while (this.queue.size() == this.limit){
            wait();
        }
        if(this.queue.size() == 0){
            notifyAll();
        }
        this.queue.add(car);
    }

    //出队
    public synchronized Car dequeue() throws InterruptedException {
        while (this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        Car car1 = this.queue.remove(0);
        return car1;
    }
}
