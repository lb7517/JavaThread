package threadcreated;

public class RunnableImpl implements Runnable {

    Counter counter;

    RunnableImpl(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        //执行方法
        System.out.println("runnable 执行");
        counter.add(2);
        System.out.println("2: "+counter.getCount());
    }
}
