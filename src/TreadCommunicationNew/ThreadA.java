package TreadCommunicationNew;

public class ThreadA implements Runnable {

    MySignal ms;

    ThreadA(MySignal ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        System.out.println("ThreadA---------");
        ms.doWait();
        System.out.println("ThreadA 执行");
    }
}
