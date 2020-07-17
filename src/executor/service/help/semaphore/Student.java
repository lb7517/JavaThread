package executor.service.help.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : lb
 * @date : 2020/7/17 16:13
 * @description :
 */
public class Student {

    private String name;

    private Semaphore semaphore;

    Student(String name, Semaphore semaphore){
        this.name = name;
        this.semaphore = semaphore;
    }

    public Integer eat(){
        try {
            semaphore.acquire();
            System.out.println(name + " 拿到了打饭的许可");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + " 饭打好了");
            semaphore.release();
            return 2;
        }
    }

}
