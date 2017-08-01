package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No104MaximumDepthofBinaryTree
 * @Description:
 * @date 2017年03月15日 下午3:23
 **/
public class No104MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
