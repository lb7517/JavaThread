package ThreadCommunication;

public class MySignal {

    private boolean hasDataToProcess = false;

    public boolean isHasDataToProcess() {
        return hasDataToProcess;
    }

    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
