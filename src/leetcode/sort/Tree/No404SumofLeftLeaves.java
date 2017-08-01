package leetcode.sort.Tree;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No404SumofLeftLeaves
 * @Description:
 * @date 2017年03月22日 下午4:28
 **/
public class No404SumofLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return 0;
        queue.offer(root);
        int rtn = 0;
        while(!queue.isEmpty()){
            TreeNode tn = queue.poll();

            if(tn.left != null && tn.left.left == null && tn.left.right == null) rtn+= tn.left.val;

            if(tn.right!=null){
                queue.offer(tn.right);
            }
            if(tn.left!=null){
                queue.offer(tn.left);
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(7);
        a.left=b;
        a.right=c;
        c.left=e;
        c.right=f;
        System.out.println(sumOfLeftLeaves(a));
    }
}
