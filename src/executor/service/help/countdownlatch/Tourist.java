package executor.service.help.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author : lb
 * @date : 2020/7/17 12:09
 * @description : 游客
 */
public class Tourist implements Runnable{

    private CountDownLatch countDownLatch;

    private String name;

    private Integer time;   // 到达时间

    Tourist(CountDownLatch countDownLatch, String name, Integer time){
        this.countDownLatch = countDownLatch;
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        synchronized (countDownLatch){
            System.out.println(name+" 到达机场，等待发登机牌");
            // 计数器减1知道减到0，才会执行await()后的流程
            countDownLatch.countDown();
        }
    }
}
