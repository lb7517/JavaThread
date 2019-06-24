package TreadCommunicationNew;

public class ThreadB implements Runnable {

    MySignal ms;

    ThreadB(MySignal ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        System.out.println("ThreadB---------");
        ms.doNotify();
        System.out.println("ThreadB 执行");
    }
}
