package product.consume.test;

/**
 * @author : lb
 * @date : 2020/7/15 18:07
 * @description :
 */
public class Consume implements Runnable{

    Container container;

    Consume(Container container){
        this.container = container;
    }

    private void decrease(){
        synchronized (this.container){
            while (this.container.container.size() == 0){
                try {
                    this.container.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer data = this.container.container.remove(0);
            System.out.println("consume 开始消费: "+data);
            this.container.notify();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.decrease();
        }
    }
}
