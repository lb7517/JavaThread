package produce.comsume;

import java.util.concurrent.TimeUnit;

//生产者
public class Produce implements Runnable {

    private Product product;

    private Signal signal; //标志

    Produce(Product product, Signal signal){
        this.product = product;
        this.signal = signal;
    }

    @Override
    public void run() {
        synchronized (product){
            System.out.println("进入生产书线程");
            System.out.println("生产");
            try {
                signal.setFlag(true);
                Thread.currentThread().sleep(2000); //模拟生产
                System.out.println("-------------等待--");
                product.notify(); //通知消费
                System.out.println("-------------等待22222--");
                Thread.currentThread().sleep(5000); //模拟其他耗时
                //和Thread.sleep实现一样，只是下面格式方便提供了时分秒
//                TimeUnit.MICROSECONDS.sleep(1000);

                System.out.println("退出生产书线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
