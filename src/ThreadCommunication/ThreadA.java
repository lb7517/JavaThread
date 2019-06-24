package ThreadCommunication;

public class ThreadA implements Runnable {

    MySignal ms;

    ThreadA(MySignal ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        if(!ms.isHasDataToProcess()){
            ms.setHasDataToProcess(true);
            System.out.println("ThreadA get Signal");
        }else {
            System.out.println("ThreadA: has Data to process");
        }
        ms.setHasDataToProcess(false);
    }
}
