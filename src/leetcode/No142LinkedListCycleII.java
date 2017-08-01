package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean isCycle = false;
        while(fast !=null &&fast.next!=null){
            if(fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) return null;

        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
