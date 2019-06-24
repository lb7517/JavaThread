package produce.comsume;

public class ThreadTest {
    public static void main(String args[]){
        Signal signal = new Signal(false); ////控制生产消费的标志
        Product p = new Product("springboot详解", "从入门到精通", 17);
        Produce produce = new Produce(p, signal);
        Consume consume = new Consume(p, signal);

        Thread tp = new Thread(produce, "produce");
        Thread tc = new Thread(consume, "consume");
        tp.start();
        tc.start();

        try {
            tp.join(15000); //默认值0表示永远等待
            tc.join(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //join的作用是阻塞之后的代码，如当前输出，要等调用了join方法的tc,tp执行完后才执行
        System.out.println("主线程执行完毕");
    }
}
