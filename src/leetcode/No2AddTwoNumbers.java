package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No2AddTwoNumbers
 * @Description:
 * @date 2017年04月23日 下午4:46
 **/
public class No2AddTwoNumbers {
     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
     }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode root = pre;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            ListNode cur = new ListNode(0);
            int temp = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
            cur.val = temp % 10;
            carry = temp / 10;
            pre.next = cur;
            pre = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return root.next;
    }
}
