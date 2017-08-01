package leetcode.sort.DataStructure;

/**
 * @author liucong
 * @ClassName: Tree
 * @Description:
 * @date 2017年03月06日 下午10:04
 **/
public class Tree {

    public class BinaryTreeNode{
        private BinaryTreeNode left = null;
        private BinaryTreeNode right = null;
        private int val;
        private boolean isFirst;

        public BinaryTreeNode(int val){
            this.val = val;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void Print(TreeNode n){
        System.out.println(n.val);
    }

    // 递归中序遍历
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            Print(root);
            inOrder(root.right);
        }
    }

    // 递归前序遍历
    public void preOrder(TreeNode root){
        if(root!=null){
            Print(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 递归后序遍历
    public void pastOrder(TreeNode root){
        if(root!=null){
            pastOrder(root.left);
            pastOrder(root.right);
            Print(root);
        }
    }

//    //非递归中序遍历：对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，此时该结点出现在栈顶，
//    //但是此时不能将其出栈并访问，因此其右孩子还为被访问。所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶，此时可以将其出栈并访问。
//    public void nonRecursiveInOrder(TreeNode<T> root){
//        Stack<TreeNode<T>> stack=new Stack<TreeNode<T>>();
//        TreeNode<T> node=root;
//        while(node!=null||!stack.isEmpty()){
//            //左子树一直入栈
//            while(node!=null){//一直找到节点左子树是空的节点
//                stack.push(node);
//                node=node.left;
//            }
//
//            node=stack.pop();//左子树是空的就是访问这个节点
//            visit(node);
//            node=node.right;//在找该节点的右子树
//        }
//    }
//
//    /*非递归前序:对于任一结点P：
//
//             1)访问结点P，并将结点P入栈;
//
//             2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;
//
//             3)直到P为NULL并且栈为空，则遍历结束。
//         */
//    public void nonRecursivePreOrder(BinaryTreeNode root){
//        Stack<TreeNode<T>> s=new Stack<TreeNode<T>>();
//        if(root!=null){
//            s.push(root);//先把根节点入栈
//            while(!s.isEmpty()){//while栈不为空
//                TreeNode<T> node=s.pop();//弹出栈
//                visit(node);
//                if(node.right!=null) s.push(node.right);//把右节点入栈
//                if(node.left!=null)  s.push(node.left); //把左节点入栈
//            }
//
//        }
//    }
//    //非递归后序遍历
//    public void nonRecursivePostOrder(TreeNode<T> root){
//        TreeNode<T> node=root;
//        TreeNode<T> preNode=null;//记录之前遍历的右结点
//        Stack<TreeNode<T>> stack=new Stack<TreeNode<T>>();
//        while(node!=null||!stack.isEmpty()){
//                  /*左子树一直入栈*/
//            while(node!=null){
//                stack.push(node);
//                node=node.left;
//            }
//            node=stack.peek();//获得栈顶节点但不出栈
//
//                  /*如果右结点为空，或者右结点之前遍历过，打印根结点*/
//            if(node.right==null||node.right==preNode){
//                visit(node);
//                node=stack.pop();
//                preNode = node;
//                node=null;
//            }
//            else{
//                node=node.right;
//            }
//
//        }
//
//    }
//    // 非递归前序遍历
//    public void nonRecursivePreOrder() {
//        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
//        BinaryTreeNode current;
//        current = root;
//        while ((current != null) || (!stack.isEmpty())) {
//            if (current != null) {
//                System.out.print(current.info);
//                stack.push(current);
//                current = current.llink;
//            } else {
//                current = (BinaryTreeNode) stack.peek();
//                stack.pop();
//                current = current.rlink;
//            }
//        }
//    }
//
//
//    // 非递归后序遍历
//    public void notRecursivePostOrder() {
//        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
//        BinaryTreeNode current;
//        current = root;
//        while ((current != null) || (!stack.isEmpty())) {
//            if (current != null) {
//                current.isFirst = true;
//                stack.push(current);
//                current = current.llink;
//            } else {
//                current = stack.peek();
//                stack.pop();
//                if (current.isFirst) {
//                    current.isFirst = false;
//                    stack.push(current);
//                    current = current.rlink;
//                } else {
//                    System.out.print(current.info);
//                    current = null;
//                }
//            }
//        }
//    }
//
//
//    // 树的层次遍历
//    public void bfs(BinaryTreeNode root){
//        Queue<BinaryTreeNode> queue = new leetcode.LinkedList<>();
//        BinaryTreeNode current = root;
//        while (current!=null||!queue.isEmpty()){
//            if(current!=null){
//                Print();
//            }
//        }
//    }
//    public void bfs(BinaryTreeNode) {
//        Queue<BinaryTreeNode> queue = new leetcode.LinkedList<BinaryTreeNode>();
//        BinaryTreeNode current;
//        current = root;
//        while ((current != null) || (!queue.isEmpty())) {
//            if (current != null) {
//                System.out.print(current.info);
//                queue.add(current.llink);
//                queue.add(current.rlink);
//                current = queue.poll();
//            } else {
//                current = queue.poll();
//            }
//        }
//    }
//    //层次遍历
//    public void levelTraverse(TreeNode<T> root){
//        //Queue是一个接口，不能直接实例化，一般使用它的实现类LinkedList当做队列用，
//        //Queue的实现类还有LinkedList, PriorityQueue, LinkedBlockingQueue, BlockingQueue, ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue
//        Queue<TreeNode<T>> queue=new leetcode.LinkedList<TreeNode<T>>();
//        TreeNode<T> node=root;
//        queue.offer(node);//队列用offer添加元素
//
//              /*对每一个节点先出队列再让其左节点和右节点入队列*/
//        while(!queue.isEmpty()){
//            node=queue.poll();//队列用poll出队列
//            if(node!=null){
//                visit(node);
//                //左右节点入队列
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//
//        }
//    }
//    //递归求树的高度
//    public int treeHeight(TreeNode<T> root){
//        if(root==null){
//            return 0;
//        }
//        else{
//            int leftTreeHeight=treeHeight(root.left);
//            int rightTreeHeight=treeHeight(root.right);
//            return leftTreeHeight>rightTreeHeight?leftTreeHeight+1:rightTreeHeight+1;
//        }
//    }
//    //递归求节点总数
//    public int treeNodes(TreeNode<T> root){
//        if(root==null){
//            return 0;
//        }
//        else{
//            int leftTreeNodes=treeNodes(root.left);
//            int rightTreeNodes=treeNodes(root.right);
//            return leftTreeNodes+rightTreeNodes+1;
//        }
//    }
//    //递归求叶子节点总数
//    public int treeLeaf(TreeNode<T> root){
//        if(root==null){
//            return 0;
//        }
//        else{
//            int leftTreeLeaf=treeLeaf(root.left);
//            int rightTreeLeaf=treeLeaf(root.right);
//            if(root.left==null&&root.right==null){
//                return leftTreeLeaf+rightTreeLeaf+1;
//            }
//            else{
//                return leftTreeLeaf+rightTreeLeaf;
//            }
//        }
//    }
//    /**
//     * 英文缩写为DFS即Depth First Search.其过程简要来说是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。对于上面的例子来说深度优先遍历的结果就是：A,B,D,E,I,C,F,G,H.(假设先走子节点的的左侧)。
//     深度优先遍历各个节点，需要使用到堆（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
//     首先将A节点压入堆中，stack（A）;
//     将A节点弹出，同时将A的子节点C，B压入堆中，此时B在堆的顶部，stack(B,C)；
//     将B节点弹出，同时将B的子节点E，D压入堆中，此时D在堆的顶部，stack（D,E,C）；
//     将D节点弹出，没有子节点压入,此时E在堆的顶部，stack（E，C）；
//     将E节点弹出，同时将E的子节点I压入，stack（I,C）；
//     ...依次往下，最终遍历完成，Java代码大概如下：
//     */
//    public void depthFirst() {
//        Stack<Map<leetcode.String, Object>> nodeStack = new Stack<Map<leetcode.String, Object>>();
//        Map<leetcode.String, Object> node = new HashMap<leetcode.String, Object>();
//        nodeStack.add(node);
//        while (!nodeStack.isEmpty()) {
//            node = nodeStack.pop();
//            System.out.println(node);
//            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
//            List<Map<leetcode.String, Object>> children = getChildren(node);
//            if (children != null && !children.isEmpty()) {
//                for (Map child : children) {
//                    nodeStack.push(child);
//                }
//            }
//        }
//    }
//    /**
//     * 广度优先
//     英文缩写为BFS即Breadth FirstSearch。其过程检验来说是对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次。对于上面的例子来说，广度优先遍历的结果是：A,B,C,D,E,F,G,H,I(假设每层节点从左到右访问)。
//     广度优先遍历各个节点，需要使用到队列（Queue）这种数据结构，queue的特点是先进先出，其实也可以使用双端队列，区别就是双端队列首位都可以插入和弹出节点。整个遍历过程如下：
//     首先将A节点插入队列中，queue（A）;
//     将A节点弹出，同时将A的子节点B，C插入队列中，此时B在队列首，C在队列尾部，queue（B，C）；
//     将B节点弹出，同时将B的子节点D，E插入队列中，此时C在队列首，E在队列尾部，queue（C，D，E）;
//     将C节点弹出，同时将C的子节点F，G，H插入队列中，此时D在队列首，H在队列尾部，queue（D，E，F，G，H）；
//     将D节点弹出，D没有子节点，此时E在队列首，H在队列尾部，queue（E，F，G，H）；
//     ...依次往下，最终遍历完成，Java代码大概如下：
//
//     */
//    public void breadthFirst() {
//        Deque<Map<leetcode.String, Object>> nodeDeque = new ArrayDeque<Map<leetcode.String, Object>>();
//        Map<leetcode.String, Object> node = new HashMap<leetcode.String, Object>();
//        nodeDeque.add(node);
//        while (!nodeDeque.isEmpty()) {
//            node = nodeDeque.peekFirst();
//            System.out.println(node);
//            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
//            List<Map<leetcode.String, Object>> children = getChildren(node);
//            if (children != null && !children.isEmpty()) {
//                for (Map child : children) {
//                    nodeDeque.add(child);
//                }
//            }
//        }
//    }
}
