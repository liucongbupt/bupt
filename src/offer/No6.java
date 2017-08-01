package offer;

/**
 * @author liucong
 * @ClassName: No6
 * @Description:
 * @date 2017年03月07日 下午4:05
 **/
public class No6 {


    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder,int[] inorder){
        if(preorder==null||inorder==null||preorder.length!=inorder.length||inorder.length<1)
            return null;
        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static BinaryTreeNode construct(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart>preend)
            return null;
        int value = preorder[prestart];
        int index = instart;
        while(index<=inend&&inorder[index]!=value){
            index++;
        }

        if(index>inend){
            throw new RuntimeException("Invalid Input");
        }

        BinaryTreeNode node = new BinaryTreeNode();
        node.value=value;
        node.left=construct(preorder,prestart+1,prestart+index-instart,inorder,instart,index-1);
        node.right=construct(preorder,prestart+index-instart+1,preend,inorder,index+1,inend);
        return node;
    }

    // 中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }

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
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {

//        test1();
//        System.out.println();
//        test2();
//        System.out.println();
//        test3();
//        System.out.println();
//        test4();
//        System.out.println();
//        test5();
//        System.out.println();
//        test6();
//        System.out.println();
//        test7();

    }
}
