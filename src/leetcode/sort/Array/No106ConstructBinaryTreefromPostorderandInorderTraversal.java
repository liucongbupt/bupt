package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No105ConstructBinaryTreefromPreorderandInorderTraversal
 * @Description:
 * @date 2017年02月27日 下午9:13
 **/

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.


 */
public class No106ConstructBinaryTreefromPostorderandInorderTraversal {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postStart = 0;
        int postEnd = postorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;
        return construct(postorder, postStart, postEnd, inorder, inStart, inEnd);
    }
    public TreeNode construct(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd){
        if(postStart>postEnd||inStart>inEnd){
            return null;
        }


        int val = postorder[postEnd];
        TreeNode p = new TreeNode(val);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(val==inorder[i]){
                k=i;
                break;
            }
        }

        p.left=construct(postorder,postStart,postStart+(k-inStart)-1,inorder,inStart,k-1);
        p.right=construct(postorder,postStart+(k-inStart),postEnd-1,inorder,k+1,inEnd);

        return p;

    }



}
