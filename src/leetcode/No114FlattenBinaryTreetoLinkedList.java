package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        TreeNode p = root;
        while (p!=null){
            if(p.left!=null){
                TreeNode left = p.left;
                while(left.right!=null) left = left.right;
                left.right=p.right;
                p.right=p.left;
                p.left=null;
            }
            p=p.right;
        }
    }
}
