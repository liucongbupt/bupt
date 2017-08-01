package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.BinaryTree
 * @Description:
 * @date 2017年03月28日 下午9:30
 **/
public class BinaryTree {
    private BinaryTree left;
    private BinaryTree right;
    private Object val;

    public BinaryTree(BinaryTree left,BinaryTree right, Object val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
