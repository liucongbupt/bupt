package Interview;

/**
 * Created by liucong on 2017/5/9.
 */
public class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    public Object val;

    public BinaryTree(BinaryTree left, BinaryTree right, Object val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

}
