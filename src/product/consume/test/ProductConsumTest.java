package product.consume.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lb
 * @date : 2020/7/15 18:25
 * @description :
 */
public class ProductConsumTest {

    public static void main(String[] args){
        List<Integer> rawer = new ArrayList<>();
        Container container = new Container(rawer, 5);
        Thread t1 = new Thread(new Produce(container), "生产者");
        Thread t2 = new Thread(new Consume(container), "消费者");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }

}
