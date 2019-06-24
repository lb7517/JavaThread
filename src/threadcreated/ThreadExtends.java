package threadcreated;

public class ThreadExtends extends Thread {

    Counter counter;

    ThreadExtends(Counter counter){
        this.counter = counter;
    }

    public void run(){
        System.out.println("thread 执行");
        counter.add(1);
        System.out.println("3: "+counter.getCount());
    }
}
