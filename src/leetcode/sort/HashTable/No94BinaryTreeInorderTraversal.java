package leetcode.sort.HashTable;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No94BinaryTreeInorderTraversal
 * @Description:
 * @date 2017年03月28日 下午9:17
 **/
public class No94BinaryTreeInorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return list;
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root){
        if(root==null) return;
        if (root.left!=null) inorder(root.left);
        list.add(root.val);
        if (root.right!=null) inorder(root.right);
    }
    public List<Integer> inorderTraversall(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack s = new Stack();
        TreeNode p = root;
        while(p!=null || !s.isEmpty()) {
            if(p!=null) {
                s.push(p);
                p = p.left;
            }
            else {
                p = (TreeNode)s.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
}
