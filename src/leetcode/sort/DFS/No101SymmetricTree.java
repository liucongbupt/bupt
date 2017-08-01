package leetcode.sort.DFS;
/**
 * @author liucong
 * @ClassName: No101SymmetricTree
 * @Description:
 * @date 2017年03月15日 下午3:12
 **/

/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class No101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }


    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }else if(left==null||right==null){
            return false;
        }

        if(left.val==right.val)
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        return false;
    }
}
