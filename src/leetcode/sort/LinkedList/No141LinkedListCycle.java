package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No141LinkedListCycle
 * @Description:
 * @date 2017年02月28日 下午9:25
 **/

/**
 * 　Given a linked list, determine if it has a cycle in it.
 　　Follow up:
 　　Can you solve it without using extra space?
 */
public class No141LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
