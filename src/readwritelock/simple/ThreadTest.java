package readwritelock.simple;

public class ThreadTest {
    public static void main(String args[]){
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Book book = new Book(readWriteLock);
        ThreadA ta = new ThreadA(book);
        System.out.println("创建并启动线程");
        Thread t1 = new Thread(ta, "t1");
//        Thread t2 = new Thread(ta, "t2");
        t1.start();
//        t2.start();

        try {
            t1.join();
//            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
