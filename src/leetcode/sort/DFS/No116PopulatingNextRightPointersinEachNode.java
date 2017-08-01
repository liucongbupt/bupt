package leetcode.sort.DFS;

import java.util.LinkedList;

/**
 * @author liucong
 * @ClassName: No116PopulatingNextRightPointersinEachNode
 * @Description:
 * @date 2017年03月15日 下午8:55
 **/
public class No116PopulatingNextRightPointersinEachNode {

    public class TreeLinkNode {

        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();

        if (root != null) {
            nodeQueue.offer(root);
            depthQueue.offer(1);
        }

        while (!nodeQueue.isEmpty()) {
            TreeLinkNode topNode = nodeQueue.poll();
            int depth = depthQueue.poll();

            if (depthQueue.isEmpty()) {
                topNode.next = null;
            } else if (depthQueue.peek() > depth) {
                topNode.next = null;
            } else {
                topNode.next = nodeQueue.peek();
            }

            if (topNode.left != null) {
                nodeQueue.offer(topNode.left);
                depthQueue.offer(depth + 1);
            }

            if (topNode.right != null) {
                nodeQueue.offer(topNode.right);
                depthQueue.offer(depth + 1);
            }
        }

    }

}
