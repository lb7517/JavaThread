package executor.service;

import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/16 15:14
 * @description :
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args){
//        scheduleTest();
        scheduleAtFixedRateTest();
//        scheduleWithFixedDelayTest();
    }

    /**
     * 延迟时间执行一次任务
     * */
    private static void scheduleTest(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Callable task = () -> {
            System.out.println("获取用户信息");
            return "Liu";
        };
        ScheduledFuture<String> scheduledFuture = scheduledExecutorService
                .schedule(task, 5, TimeUnit.SECONDS);
        try {
            Long delay = scheduledFuture.getDelay(TimeUnit.SECONDS);
            System.out.println("剩余延迟时间: "+delay);
            System.out.println("执行任务结果: "+scheduledFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        scheduledExecutorService.shutdown();
    }

    /**
     * 固定频率执行任务, 弊端: 在指定间隔时间执行，任务还没执行完，下一次任务有来了，会导致加快执行
     * */
    private static void  scheduleAtFixedRateTest(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取用户信息");
        };
        // 从1s开始，每5s执行一次
        ScheduledFuture scheduledFuture = scheduledExecutorService
                .scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
        Long delay = scheduledFuture.getDelay(TimeUnit.SECONDS);
        System.out.println("剩余延迟时间: "+delay);
//        scheduledExecutorService.shutdown();
    }

    /**
     * 第一次任务执行完之后，到下一次任务开始的事件间隔一致
     * */
    private static void  scheduleWithFixedDelayTest(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取用户信息");
        };
        // 从10s开始，每60s执行一次
        ScheduledFuture scheduledFuture = scheduledExecutorService
                .scheduleWithFixedDelay(task, 0, 5, TimeUnit.SECONDS);
        Long delay = scheduledFuture.getDelay(TimeUnit.SECONDS);
        System.out.println("剩余延迟时间: "+delay);
//        scheduledExecutorService.shutdown();
    }

}
