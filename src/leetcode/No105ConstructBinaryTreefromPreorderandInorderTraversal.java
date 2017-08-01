package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No105ConstructBinaryTreefromPreorderandInorderTraversal
 * @Description:
 * @date 2017年04月24日 下午3:05
 **/
public class No105ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||inorder.length!=preorder.length||preorder.length<1)
            return null;

        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode construct(int[] preorder, int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart>preend||instart>inend)
            return null;

        int val = preorder[prestart];
        int idx = instart;
        while(idx<=inend&&inorder[idx]!=val){
            idx++;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = construct(preorder,prestart+1,prestart+idx-instart,inorder,instart,idx-1);
        root.right = construct(preorder,prestart+idx-instart+1,preend,inorder,idx+1,inend);

        return root;
    }
    // 中序遍历二叉树
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }

    public static void main(String[] args) {
        System.out.println("a" +
                "");
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
}
