package ThreadCommunication;

public class ThreadTest {
    public static void main(String args[]){
        MySignal ms = new MySignal();
        ThreadA ta = new ThreadA(ms);
        ThreadB tb = new ThreadB(ms);

        Thread t1 = new Thread(ta, "threadA");
        Thread t2 = new Thread(tb, "threadB");
        t1.start();
        t2.start();
    }
}
