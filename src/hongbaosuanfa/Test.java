package hongbaosuanfa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String args[]) throws InterruptedException {
        double totalPrice = 100;
        int totalNum = 50;
        List<Double> list = new ArrayList<Double>();
        Entity entity = new Entity(list, totalPrice, totalNum);
        ReentrantLock reentrantLock = new ReentrantLock();
        ExecutorService fixedThread = Executors.newFixedThreadPool(10);
        for(int i = 0; i < totalNum; i++){
            fixedThread.execute(new ThreadA(reentrantLock, entity));
        }

        Thread.sleep(4000);
        fixedThread.shutdown();
        System.out.println("entity: "+entity.getList());

        Iterator<Double> iterable = entity.getList().iterator();
        double num = 0;
        while (iterable.hasNext()){
            num = num + iterable.next();
        }
        System.out.println("num: "+num);
    }
}
