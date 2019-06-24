package TreadCommunicationNew;

public class MySignal {

    MonitorObject mo = new MonitorObject();

    public void doWait(){
        synchronized (mo){
            try {
                mo.wait();
                new Thread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized (mo){
            mo.notify();
        }
    }
}