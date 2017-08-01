package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No100SameTree
 * @Description:
 * @date 2017年03月15日 下午3:08
 **/

/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class No100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null && q==null){
//            return true;
//        }else if(p==null || q==null){
//            return false;
//        }
//
//        if(p.val==q.val){
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }else{
//            return false;
//        }
        if(p==null&&q==null) {
            return true;
        }else if(p==null||q==null){
            return false;
        }

        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

        }else{
            return false;
        }
    }
}
