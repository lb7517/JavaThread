package threadcreated;

public class Counter {

    private volatile int count = 0; //volatile保证同步，对线程可见
//    private int count = 0;

    public void add(int value){
        this.count = this.count + value;
    }

    public int getCount(){
        return count;
    }
}
