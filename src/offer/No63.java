package offer;

/**
 * @author liucong
 * @ClassName: No63
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No63 {
    static BinaryTreeNode kthNode(BinaryTreeNode root,int k){
        if (root==null||k<1)
            return null;

        int[] tmp = {k};
        return kthNodeCore(root,tmp);
    }

    static BinaryTreeNode kthNodeCore(BinaryTreeNode root,int[] k){
        BinaryTreeNode node = null;

        if (root.left!=null){
            node = kthNodeCore(root.left,k);
        }

        if (node==null){

            if (k[0]==1){
                node = root;
            }else {
                k[0]--;
            }
        }

        if (node==null && root.right!=null){
            node=kthNodeCore(root.right,k);
        }
        return node;
    }



    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(4);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(6);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(3);
        BinaryTreeNode n6 = new BinaryTreeNode(5);
        BinaryTreeNode n7 = new BinaryTreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(kthNode(n1,1).value);
        System.out.println(kthNode(n1,2).value);
        System.out.println(kthNode(n1,3).value);
        System.out.println(kthNode(n1,4).value);
        System.out.println(kthNode(n1,5).value);
        System.out.println(kthNode(n1,6).value);
        System.out.println(kthNode(n1,7).value);

    }

    /**
     * 中序遍历一棵树
     * @param root
     */
    private static void print(BinaryTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.printf("%-3d", root.value);
            print(root.right);
        }
    }
}
