package deadlock;

public class ThreadB implements Runnable {

    TreeNode parent;

    TreeNode children;

    ThreadB(TreeNode parent, TreeNode children){
        this.parent = parent;
        this.children = children;
    }

    @Override
    public void run() {
        children.setParent(parent);
    }
}
