package Interview;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: Interview.TreeTravese
 * @Description:
 * @date 2017年03月28日 下午9:28
 **/
public class TreeTravese {



    public static void visit(BinaryTree bt) {
        System.out.print(bt.val + " ");
    }

    //递归先序遍历
    public static void pre(BinaryTree root) {
        if (root == null)
            return;
        visit(root);
        if (root.left != null)
            pre(root.left);
        if (root.right != null)
            pre(root.right);

    }

    //递归中序遍历
    public static void in(BinaryTree root) {
        if (root == null)
            return;
        if (root.left != null)
            in(root.left);
        visit(root);
        if (root.right != null)
            in(root.right);
    }

    //递归后序遍历
    public static void post(BinaryTree root) {
        if (root == null)
            return;
        if (root.left != null)
            post(root.left);
        if (root.right != null)
            post(root.right);
        visit(root);
    }



    //非递归先序遍历1
    public static void preTraverse1(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree node = root;
        if (node!=null){
            s.push(node);
            while (!s.isEmpty()){
                node = s.pop();
                visit(node);
                if (node.right!=null)
                    s.push(node.right);
                if (node.left!=null)
                    s.push(node.left);
            }
        }

    }
    //非递归先序遍历
    public static void preTraverse(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree node = root;
        while (node!=null||!s.isEmpty()){
            while (node!=null){
                visit(node);
                s.push(node);
                node = node.left;
            }
            if (!s.isEmpty()){
                node = s.pop();
                node = node.right;
            }
        }
    }
    //非递归中序遍历
    public static void inTraverse(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree node = root;
        while (node!=null||!s.isEmpty()){
            while (node!=null){
                s.push(node);
                node = node.left;
            }
            if (!s.isEmpty()){
                node = s.pop();
                visit(node);
                node = node.right;
            }
        }
    }

    //非递归后序遍历
    public static void postTraverse(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree node = root;
        //pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        BinaryTree pre = node;
        while (node != null || !s.isEmpty()) {
            while (node!=null){
                s.push(node);
                node = node.left;
            }
            if (!s.isEmpty()) {
                node = s.peek();
                if (node.right != null && node.right != pre) {
                    node = node.right;
                } else {
                    node = s.pop();
                    visit(node);
                    pre = node;
                    node = null;
                }
            }
        }
    }



    //非递归后序遍历2
    public static void postTraverse2(BinaryTree root) {
        Stack s = new Stack();
        BinaryTree p = root;
        //pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        BinaryTree pre = p;
        //flag标记是出栈还是继续将左孩子进栈
        boolean flag = true;
        while (p != null || !s.isEmpty()) {
            if (p != null && flag) {
                s.push(p);
                p = p.left;
            } else {
                if (s.isEmpty()) return;
                p = (BinaryTree) s.peek();
                if (p.right != null && p.right != pre) {
                    p = p.right;
                    flag = true;
                } else {
                    p = (BinaryTree) s.pop();
                    visit(p);
                    flag = false;
                    pre = p;
                }
            }
        }
    }

    //非递归后序遍历3
    public static void postTraverse3(BinaryTree root) {
        Stack s = new Stack();
        BinaryTree p = root;
        //pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        BinaryTree pre = p;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                if (s.isEmpty()) return;
                p = (BinaryTree) s.peek();
                if (p.right != null && p.right != pre) {
                    p = p.right;
                } else {
                    p = (BinaryTree) s.pop();
                    visit(p);
                    pre = p;
                    p = null;
                }
            }
        }
    }
    /** 非递归实现前序遍历 */
//    protected static void iterativePreorder(Node p) {
//        Stack<Node> stack = new Stack<Node>();
//        if (p != null) {
//            stack.push(p);
//            while (!stack.empty()) {
//                p = stack.pop();
//                visit(p);
//                if (p.getRight() != null)
//                    stack.push(p.getRight());
//                if (p.getLeft() != null)
//                    stack.push(p.getLeft());
//            }
//        }
//    }
    /** 非递归实现后序遍历 */
//    protected static void iterativePostorder(Node p) {
//        Node q = p;
//        Stack<Node> stack = new Stack<Node>();
//        while (p != null) {
//            // 左子树入栈
//            for (; p.getLeft() != null; p = p.getLeft())
//                stack.push(p);
//            // 当前节点无右子或右子已经输出
//            while (p != null && (p.getRight() == null || p.getRight() == q)) {
//                visit(p);
//                q = p;// 记录上一个已输出节点
//                if (stack.empty())
//                    return;
//                p = stack.pop();
//            }
//            // 处理右子
//            stack.push(p);
//            p = p.getRight();
//        }
//    }
//
//    /** 非递归实现后序遍历 双栈法 */
//    protected static void iterativePostorder2(Node p) {
//        Stack<Node> lstack = new Stack<Node>();
//        Stack<Node> rstack = new Stack<Node>();
//        Node node = p, right;
//        do {
//            while (node != null) {
//                right = node.getRight();
//                lstack.push(node);
//                rstack.push(right);
//                node = node.getLeft();
//            }
//            node = lstack.pop();
//            right = rstack.pop();
//            if (right == null) {
//                visit(node);
//            } else {
//                lstack.push(node);
//                rstack.push(null);
//            }
//            node = right;
//        } while (lstack.size() > 0 || rstack.size() > 0);
//    }
//
//    /** 非递归实现后序遍历 单栈法*/
//    protected static void iterativePostorder3(Node p) {
//        Stack<Node> stack = new Stack<Node>();
//        Node node = p, prev = p;
//        while (node != null || stack.size() > 0) {
//            while (node != null) {
//                stack.push(node);
//                node = node.getLeft();
//            }
//            if (stack.size() > 0) {
//                Node temp = stack.peek().getRight();
//                if (temp == null || temp == prev) {
//                    node = stack.pop();
//                    visit(node);
//                    prev = node;
//                    node = null;
//                } else {
//                    node = temp;
//                }
//            }
//
//        }
//    }
//
//    /** 非递归实现后序遍历4 双栈法*/
//    protected static void iterativePostorder4(Node p) {
//        Stack<Node> stack = new Stack<Node>();
//        Stack<Node> temp = new Stack<Node>();
//        Node node = p;
//        while (node != null || stack.size() > 0) {
//            while (node != null) {
//                temp.push(node);
//                stack.push(node);
//                node = node.getRight();
//            }
//            if (stack.size() > 0) {
//                node = stack.pop();
//                node = node.getLeft();
//            }
//        }
//        while (temp.size() > 0) {
//            node = temp.pop();
//            visit(node);
//        }
//    }
//
//    /** 非递归实现中序遍历 */
//    protected static void iterativeInorder(Node p) {
//        Stack<Node> stack = new Stack<Node>();
//        while (p != null) {
//            while (p != null) {
//                if (p.getRight() != null)
//                    stack.push(p.getRight());// 当前节点右子入栈
//                stack.push(p);// 当前节点入栈
//                p = p.getLeft();
//            }
//            p = stack.pop();
//            while (!stack.empty() && p.getRight() == null) {
//                visit(p);
//                p = stack.pop();
//            }
//            visit(p);
//            if (!stack.empty())
//                p = stack.pop();
//            else
//                p = null;
//        }
//    }

    public static void main(String[] args) {
        BinaryTree G = new BinaryTree(null, null, 'G');
        BinaryTree H = new BinaryTree(null, null, 'H');
        BinaryTree F = new BinaryTree(G, H, 'F');
        BinaryTree D = new BinaryTree(null, F, 'D');
        BinaryTree E = new BinaryTree(null, null, 'E');
        BinaryTree B = new BinaryTree(D, E, 'B');
        BinaryTree C = new BinaryTree(null, null, 'C');
        BinaryTree A = new BinaryTree(B, C, 'A');

        System.out.println("先序遍历。。。。。。。");
        pre(A);
        System.out.println();

        System.out.println("非递归先序遍历。。。。。。。");
        preTraverse(A);
        System.out.println();

        System.out.println("非递归先序遍历1。。。。。。。");
        preTraverse1(A);
        System.out.println();

        System.out.println("中序遍历。。。。。。。");
        in(A);
        System.out.println();

        System.out.println("非递归中序遍历。。。。。。。");
        inTraverse(A);
        System.out.println();

        System.out.println("后序遍历。。。。。。。");
        post(A);
        System.out.println();

        System.out.println("非递归后序遍历。。。。。。。");
        postTraverse(A);
        System.out.println();

//        System.out.println("非递归后序遍历2。。。。。。。");
//        postTraverse2(A);
//        System.out.println();
    }
}