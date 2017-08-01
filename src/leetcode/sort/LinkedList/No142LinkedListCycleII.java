package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No142LinkedListCycleII
 * @Description:
 * @date 2017年02月28日 下午9:23
 **/

import java.util.List;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 */
public class No142LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return  null;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast!=slow){
            if(fast==null||fast.next==null)
                return null;

            fast=fast.next.next;
            slow = slow.next;

        }



        while(head!=slow.next){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}
