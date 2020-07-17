package executor.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/16 12:02
 * @description :
 */
public class ExecutorServiceTest2 {

    volatile int count = 1;

    private static void testInvokeAll () {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    return "task1";
                }, () -> {
                    return "task2";
                }, () -> {
                    return "task3";
                });
        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            for(Future<String> future: futures){
                String result = future.get(1, TimeUnit.SECONDS);
                System.out.println("结果: "+result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void testInvokeAny () {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    Thread.sleep(2000);
                    return "task1";
                }, () -> {
                    TimeUnit.SECONDS.sleep(1);
                    return "task2";
                }, () -> {
                    Thread.sleep(3000);
                    return "task3";
                });
        String result = null;
        try {
            result = executorService.invokeAny(callables);
            System.out.println("结果: "+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args){
//        testInvokeAll();
        testInvokeAny();
    }

}
