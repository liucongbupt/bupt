package leetcode.sort.DFS;

import java.util.LinkedList;

/**
 * @author liucong
 * @ClassName: No111MinimumDepthofBinaryTree
 * @Description:
 * @date 2017年03月15日 下午4:46
 **/
public class No111MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root);
    }

    private int getDepth(TreeNode root){
        if(root==null) return 0;

        if(root.left==null&&root.right==null){
            return 1;
        }

        return Math.min(getDepth(root.left),getDepth(root.right))+1;
    }
    public int minDepthh(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left == null && curr.right == null){
                return count;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }

        return 0;
    }
}
