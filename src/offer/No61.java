package offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No61
 * @Description:
 * @date 2017年04月05日 下午2:43
 **/
public class No61 {
    public static void print(BinaryTreeNode root) {

        if (root == null) {
            return;
        }


        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (current.size() > 0) {

            // 从最后一个开始取
            node = current.remove(current.size() - 1);

            System.out.printf("%-3d", node.value);

            // 当前是从左往右打印的，那就按从左往右入栈
            if (flag == 0) {
                if (node.left != null) {
                    reverse.add(node.left);
                }

                if (node.right != null) {
                    reverse.add(node.right);
                }


            }
            // 当前是从右往左打印的，那就按从右往左入栈
            else {
                if (node.right != null) {
                    reverse.add(node.right);
                }

                if (node.left != null) {
                    reverse.add(node.left);
                }
            }

            if (current.size() == 0) {
                flag = 1 - flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }

    public static void printt(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isForward = true;
        int size = queue.size();
        while (size != 0) {
            List<BinaryTreeNode> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (isForward) list.add(node);
                else list.add(0, node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            isForward = !isForward;
            size = queue.size();
            for (BinaryTreeNode t : list
                    ) {
                System.out.print(t.value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
        printt(n1);
    }
}
