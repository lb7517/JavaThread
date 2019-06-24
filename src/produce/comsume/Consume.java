package produce.comsume;

//消费者
public class Consume implements Runnable {

    Product product;

    Signal signal; //标志

    Consume(Product product, Signal signal){
        this.product = product;
        this.signal = signal;
    }

    @Override
    public void run() {
        synchronized (product){
            System.out.println("进入消费者线程");
            System.out.println("1 flag: "+ signal.isFlag());
            while (!signal.isFlag()){
                try {
                    System.out.println("还没生产，进入等待");
                    product.wait();
                    System.out.println("结束消费等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("2 flag: " + signal.isFlag());
            System.out.println("消费书");
            System.out.println("退出消费线程");

        }
    }
}
