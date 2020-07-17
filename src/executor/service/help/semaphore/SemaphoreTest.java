package executor.service.help.semaphore;

import java.util.concurrent.*;

/**
 * @author : lb
 * @date : 2020/7/17 16:11
 * @description : 并发辅助类，新号量
 */
public class SemaphoreTest {

    // 定义信号量
    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> result1 = executorService.submit(() -> {
           return new Student("哈登", semaphore).eat();
        });
        Future<Integer> result2 = executorService.submit(() -> {
            return new Student("戈登", semaphore).eat();
        });
        Future<Integer> result3 = executorService.submit(() -> new Student("姚明", semaphore).eat());
        try {
            Object data = result3.get();
            System.out.println("data: "+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
