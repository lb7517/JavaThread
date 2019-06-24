package blockqueue;

public class Car {

    private volatile String des;

    Car(String des){
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
