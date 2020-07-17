package executor.service.help.cyclicbarrier;

import executor.service.help.countdownlatch.Tourist;

import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/17 15:29
 * @description : 并发的辅助类，控制异步流程执行完，继续执行(可重用)
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Guide());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new TouristCyc(cyclicBarrier, "哈登", 5));
        executorService.execute(new TouristCyc(cyclicBarrier, "戈登", 1));
        executorService.execute(new TouristCyc(cyclicBarrier, "戈登", 3));

//        executorService.shutdown();
        System.out.println("结束");
    }
}
