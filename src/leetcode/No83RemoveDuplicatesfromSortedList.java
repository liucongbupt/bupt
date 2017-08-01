package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode list = head;
        dummy.next = list;
        while (list!=null){
            if (list.next==null)
                break;

            if (list.val==list.next.val)
                list.next=list.next.next;
            else
                list = list.next;
        }
        return dummy.next;
    }
}
