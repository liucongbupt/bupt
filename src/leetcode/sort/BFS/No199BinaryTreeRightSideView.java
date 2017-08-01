package leetcode.sort.BFS;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No199BinaryTreeRightSideView
 * @Description:
 * @date 2017年03月22日 下午3:42
 **/
public class No199BinaryTreeRightSideView {
    public List<Integer> rightSideVieww(TreeNode root) {
        List<Integer> rtn  = new ArrayList<>();
        if (root == null) return rtn
                ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = q.size();
        while (size!=0){
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if(i==0) rtn.add(t.val);
                if(t.right!=null) q.add(t.right);
                if(t.left!=null) q.add(t.left);
            }
            size=q.size();
        }
        return rtn;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rtn  = new ArrayList<>();
        if (root == null) return rtn;
        helper(root,rtn,0);
        return rtn;
    }
    private void helper(TreeNode root,List<Integer> list,int level){
        if(root==null) return;;
        if(level==list.size()) list.add(root.val);

        helper(root.right,list,level+1);
        helper(root.left,list,level+1);
    }
}
