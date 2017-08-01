package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No106ConstructBinaryTreefromInorderandPostorderTraversal
 * @Description:
 * @date 2017年04月24日 下午3:41
 **/
public class No106ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||inorder.length!=postorder.length||postorder.length<1)
            return null;

        return construct(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode construct(int[] inorder, int instart,int inend,int[] postorder,int poststart,int postend){
        if(poststart>postend||instart>inend)
            return null;

        int val = postorder[postend];
        int idx = instart;
        while(idx<=inend&&inorder[idx]!=val){
            idx++;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        root.left = construct(inorder,instart,idx-1,postorder,poststart,poststart+idx-instart-1);
        root.right = construct(inorder,idx+1,inend,postorder,poststart+idx-instart,postend-1);

        return root;
    }
}
