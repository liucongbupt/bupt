package leetcode.sort.BFS;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No513FindBottomLeftTreeValue
 * @Description:
 * @date 2017年03月22日 下午3:16
 **/
public class No513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode rtn = null;
        while(queue.isEmpty()){
            rtn = queue.poll();
            if(rtn.right!=null){
                queue.offer(rtn.right);
            }
            if(rtn.left!=null){
                queue.offer(rtn.left);
            }
        }
        return rtn.val;
    }
}
