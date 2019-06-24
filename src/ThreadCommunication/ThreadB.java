package ThreadCommunication;

public class ThreadB implements Runnable {

    MySignal ms;

    ThreadB(MySignal ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        /*if(!ms.isHasDataToProcess()){
            ms.setHasDataToProcess(true);
            System.out.println("ThreadB get MySignal");
        }else{
            System.out.println("ThreadB: has Data to process");
        }*/

        while (!ms.isHasDataToProcess()){
            ms.setHasDataToProcess(true);
            System.out.println("ThreadB get Signal");
        }
    }
}
