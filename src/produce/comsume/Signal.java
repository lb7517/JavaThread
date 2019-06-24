package produce.comsume;

//信号量的作用
public class Signal {

    private boolean flag; //生产时为true

    Signal(){}

    Signal(boolean flag){
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
