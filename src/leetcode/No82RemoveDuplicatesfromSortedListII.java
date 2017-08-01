package leetcode;

import java.util.List;

/**
 * Created by liucong on 2017/5/10.
 */
public class No82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        while (cur!=null){
            while (cur.next!=null&&cur.val==cur.next.val)
                cur = cur.next;
            if (pre.next == cur)
                pre = pre.next;
            else
                pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
