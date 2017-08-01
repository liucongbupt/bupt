package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No98ValidateBinarySearchTree
 * @Description:
 * @date 2017年03月15日 下午11:04
 **/
public class No98ValidateBinarySearchTree {
//    public boolean isValidBST(TreeNode root) {
//        if(root==null) return true;
//        return isValidBST(root,Double.NEGATIVE_INFINIT,Double.POSITIVE_INFINITYE);
//    }
//    public boolean isValidBST(TreeNode root,double min,double max){
//        if(root.val<=min||root.val>=max)
//            return false;
//        if(root.left!=null&&!isValidBST(root.left,min,root.val))
//            return false;
//        if(root.right!=null&&!isValidBST(root.right,root.val,max))
//            return false;
//        return true;
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        if(root==null)
//            return true;
//
//        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
//    }
//
//    public boolean helper(TreeNode root, double low, double high){
//
//        if(root.val<=low || root.val>=high)
//            return false;
//
//        if(root.left!=null && !helper(root.left, low, root.val)){
//            return false;
//        }
//
//        if(root.right!=null && !helper(root.right, root.val, high)){
//            return false;
//        }
//
//        return true;
//    }
//
//
//    public boolean isValidBSTT(TreeNode root) {
//        if(root==null) return true;
//        return isValidBSTT(root,Double.NEGATIVE_INFINITE,Double.POSITIVE_INFINITYE);
//    }
//    public boolean isValidBSTT(TreeNode root,double min,double max){
//        if(root==null)
//            return true
//        if(root.val<=min||root.val>=max)
//            return false;
//        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
//    }
}
