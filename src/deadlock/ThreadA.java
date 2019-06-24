package deadlock;

public class ThreadA implements Runnable {

    TreeNode parent;

    TreeNode children;

    ThreadA(TreeNode parent, TreeNode children){
        this.parent = parent;
        this.children = children;
    }

    @Override
    public void run() {
        parent.addChild(children);
    }
}
