package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String args[]){
        long star = System.currentTimeMillis();


        //等凉菜
        Callable ca1 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "凉菜线程执行完毕";
            }
        };
        FutureTask f1 = new FutureTask(ca1);
        new Thread(f1).start();

        //等饭
        Callable ca2 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                return "米饭线程自行完毕";
            }
        };
        FutureTask f2 = new FutureTask(ca2);
        new Thread(f2).start();
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("准备时: "+(end-star));
    }
}
