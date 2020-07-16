package executor.service;

import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/16 11:09
 * @description :
 */
public class ExecutorServiceTest1 {

    public static void main(String[] args){
        // 无返回值
        Runnable runnable = (() -> {
            System.out.println("1111");
        });
        // 有返回值
        Callable<String> callable = (() -> {
            System.out.println("1111");
            Thread.sleep(2000);
            return "ok";
        });
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(callable);
        try {
            System.out.println("继续执行主线程");
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println("结果是: " + result);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
