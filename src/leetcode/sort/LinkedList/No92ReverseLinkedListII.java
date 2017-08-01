package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No92ReverseLinkedListII
 * @Description:
 * @date 2017年03月14日 下午2:44
 **/

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 Subscribe to see which companies asked this question.
 */
public class No92ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(n<m||head==null||head.next==null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy.next;
        for (int i = 1; i < m; i++) {
            p = p.next;
            q = q.next;
        }
        ListNode temp = q;
        ListNode z = q.next;
        for (int i = 0; i < (n-m); i++) {
            ListNode node = z.next;
            p.next=z;
            z.next=q;
            q=p.next;
            z=node;
        }
        temp.next=z;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(9);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        reverseBetween(a,2,4);
    }

}
