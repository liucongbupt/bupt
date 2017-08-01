package leetcode.sort.LinkedList;


/**
 * @author liucong
 * @ClassName: ConvertSortedListtoBinarySearchTree
 * @Description:
 * @date 2017年03月14日 下午4:19
 **/
public class No109ConvertSortedListtoBinarySearchTree {
     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
     }
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }

    ListNode cur;
//
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) return null;
//        ListNode node = head;
//        int count = 0;
//        while (node != null) {
//            node = node.next;
//            count++;
//        }
//        cur = head;
//        return sortedListToBST(0, count - 1);
//    }
//
//    private TreeNode sortedListToBST(int lo, int hi) {
//        if (lo > hi) return null;
//        int mid = lo + (hi - lo)/ 2;
//        TreeNode left = sortedListToBST(lo, mid - 1);
//        TreeNode root = new TreeNode(cur.val);
//        cur = cur.next;
//        TreeNode right = sortedListToBST(mid + 1, hi);
//        root.left = left;
//        root.right = right;
//        return root;
//    }

    public TreeNode sortedListToBST(ListNode head) {

        return buildBST(head,null);
    }

    private TreeNode buildBST(ListNode head, ListNode end){
            if(head==end) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null||fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        TreeNode root  =  new TreeNode(slow.val);
        root.left = buildBST(head,slow);
        root.right=buildBST(slow.next,end);
        return root;
    }


}
