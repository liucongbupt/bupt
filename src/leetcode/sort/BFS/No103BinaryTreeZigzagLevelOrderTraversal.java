package leetcode.sort.BFS;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No103BinaryTreeZigzagLevelOrderTraversal
 * @Description:
 * @date 2017年03月22日 下午3:38
 **/
public class No103BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rtn = new LinkedList<>();
        if (root == null) return rtn;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = q.size();

        boolean isForward = true;
        while (size != 0) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                TreeNode t = q.poll();

                if (isForward) list.add(t.val);
                else list.add(0, t.val);

                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            rtn.add(list);
            size = q.size();
            isForward = !isForward;
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
        zigzagLevelOrder(a);
    }
}
