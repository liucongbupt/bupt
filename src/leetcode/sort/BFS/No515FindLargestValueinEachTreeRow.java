package leetcode.sort.BFS;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No515FindLargestValueinEachTreeRow
 * @Description:
 * @date 2017年03月22日 下午2:41
 **/
public class No515FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = root==null?0:1;
        while (size>0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode e = queue.poll();
                if (e.val > max) max = e.val;
                if (e.left != null) {
                    queue.offer(e.left);
                }
                if (e.right != null) {
                    queue.offer(e.right);
                }
            }
            list.add(max);
            size=queue.size();
        }
        return list;
    }
}
