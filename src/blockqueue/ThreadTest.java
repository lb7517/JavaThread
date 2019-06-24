package blockqueue;

public class ThreadTest {
    public static void main(String args[]){
        Car car = new Car("本田");
        BlockingQueue blockingQueue = new BlockingQueue(10);
        ThreadA ta = new ThreadA(blockingQueue, car);

        Thread t1 = new Thread(ta, "t1");
        Thread t2 = new Thread(ta, "t2");
        t1.start();
        t2.start();

        String a ;
    }
}
