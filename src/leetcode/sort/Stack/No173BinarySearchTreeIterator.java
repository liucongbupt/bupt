package leetcode.sort.Stack;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No173BinarySearchTreeIterator
 * @Description:
 * @date 2017年04月11日 下午10:02
 **/
public class No173BinarySearchTreeIterator {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class BSTIterator {
        Stack<Integer> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            in(root);
        }
        public  void in(TreeNode root) {
            if(root == null)return;
            if(root.right != null)in(root.right);
            stack.add(root.val);
            if(root.left != null)in(root.left);
        }
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            return stack.pop();
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
