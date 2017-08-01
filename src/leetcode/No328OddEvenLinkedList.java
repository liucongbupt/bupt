package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode connect = even;
        while (odd!=null&&even!=null){
            if(even.next==null)
                break;
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = connect;
        return head;
    }
}
