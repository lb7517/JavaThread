package executor.service.help.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : lb
 * @date : 2020/7/17 12:09
 * @description : 游客
 */
public class TouristCyc implements Runnable{

    private CyclicBarrier cyclicBarrier;

    private String name;

    private Integer time;   // 到达时间

    TouristCyc(CyclicBarrier cyclicBarrier, String name, Integer time){
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
//        synchronized (cyclicBarrier){
            System.out.println(name+" 到达机场，等待发登机牌");
            // 计数器减1知道减到0，才会执行await()后的流程
            try {
                cyclicBarrier.await();
                Thread.sleep(time);
                System.out.println(name+" 开始登机");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
//        }
    }
}
