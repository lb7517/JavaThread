package hongbaosuanfa;

import java.util.List;

public class Entity {

    private double totalPrice;

    private int totalNum;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    private List list;

    Entity(List list, double totalPrice, int totalNum){
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.list = list;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

}
