package executor.service.help.countdownlatch;

import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/17 12:07
 * @description : 并发的辅助类，控制异步流程执行完，继续执行(不可重用)
 */
public class CountDownLatchTest {
    public static void main(String[] args){
//        threadCountDownLatchTest();
        executorServiceCountDownLatchTest();
    }

    /**
     * 通过线程池
     * */
    private static void executorServiceCountDownLatchTest(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable runnable1 = () -> {
                System.out.println("哈登 到达机场，等待发登机牌");
                countDownLatch.countDown();
                int a = 10/0;
                return a;
        };
        Runnable runnable2 = new Tourist(countDownLatch, "戈登", 1);
        Runnable runnable3 = new Tourist(countDownLatch, "姚明", 3);
        Future future1 = executorService.submit(runnable1);
        Future future2 = executorService.submit(runnable2);
        Future future3 = executorService.submit(runnable3);
        try {
            // 关键(countDownLatch.countDown数量减到0)即 等待所有线程执行完，再继续执行后面的流程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Object object = future1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("结束");
    }

    /**
     * 通过Thread创建线程
     * */
    private static void threadCountDownLatchTest(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Tourist tourist1 = new Tourist(countDownLatch, "哈登", 5);
        Thread thread1 = new Thread(tourist1, "1");
        thread1.start();

        Tourist tourist2 = new Tourist(countDownLatch, "戈登", 1);
        Thread thread2 = new Thread(tourist2, "2");
        thread2.start();

        Tourist tourist3 = new Tourist(countDownLatch, "姚明", 3);
        Thread thread3 = new Thread(tourist3, "3");
        thread3.start();

        try {
            // 关键(countDownLatch.countDown数量减到0)即 等待所有线程执行完，再继续执行后面的流程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
