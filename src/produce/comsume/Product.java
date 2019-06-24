package produce.comsume;

public class Product {

    private String name;

    private String des;

    private double price;

    Product(){}

    Product(String name, String des, double price){
        this.name = name;
        this.des = des;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
