package leetcode.sort.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No117PopulatingNextRightPointersinEachNodeII
 * @Description:
 * @date 2017年03月15日 下午11:02
 **/
public class No117PopulatingNextRightPointersinEachNodeII {
    public class TreeLinkNode {

        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {

        if(root==null)
            return;
        Queue<TreeLinkNode> node = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        if(root!=null){
            node.offer(root);
            depth.offer(1);
        }
        while (!node.isEmpty()){
            TreeLinkNode top = node.poll();
            int curDepth = depth.poll();

            if(depth.isEmpty()){
                top.next=null;
            }else if(depth.peek()>curDepth){
                top.next=null;
            }else {
                top.next=node.peek();
            }

            if(top.left!=null){
                node.offer(top.left);
                depth.offer(curDepth+1);
            }
            if(top.right!=null){
                node.offer(top.right);
                depth.offer(curDepth+1);
            }

        }
    }
}
