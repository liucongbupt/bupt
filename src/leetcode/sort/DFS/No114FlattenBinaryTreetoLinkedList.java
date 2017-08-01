package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No114FlattenBinaryTreetoLinkedList
 * @Description:
 * @date 2017年03月15日 下午6:29
 **/
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

//    public void flatten(TreeNode root) {
//        TreeNode p = root;
//        while (p != null) {
//            if(p.left != null) {
//                TreeNode left = p.left;
//                while(left.right != null) left = left.right;
//                left.right = p.right;
//                p.right = p.left;
//                p.left = null;
//            }
//            p = p.right;
//        }
//    }
}
