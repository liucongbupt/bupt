package leetcode.sort.Stack;


import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No144BinaryTreePreorderTraversal
 * @Description:
 * @date 2017年04月11日 下午9:42
 **/
public class No144BinaryTreePreorderTraversal {
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pre(root);
        return list;
    }
    public void pre(TreeNode root) {
        if(root==null) return;
        list.add(root.val);
        if(root.left!=null) pre(root.left);
        if(root.right!=null) pre(root.right);
    }
}
