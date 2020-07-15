package product.consume.test;

/**
 * @author : lb
 * @date : 2020/7/15 18:06
 * @description :
 */
public class Produce implements Runnable{

    Container container;

    Integer count = 0;

    Produce(Container container){
        this.container = container;
    }

    private void increase(){
        synchronized (container){
            // 超出容量
            while (container.container.size() >= container.max_num){
                try {
                    container.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ++count;
            System.out.println("produce开始生产: "+count);
            this.container.container.add(count);
            this.container.notify();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.increase();
        }

    }
}
