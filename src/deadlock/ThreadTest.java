package deadlock;

public class ThreadTest {
    public static void main(String args[]){
        TreeNode parent = new TreeNode();
        TreeNode children = new TreeNode();

        ThreadA ta = new ThreadA(parent, children);
        ThreadB tb = new ThreadB(parent, children);
        Thread t1 = new Thread(ta, "threadA");
        Thread t2 = new Thread(tb, "threadB");

        t1.start();
        t2.start();
    }
}
