package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No24SwapNodesinPairs
 * @Description:
 * @date 2017年05月03日 下午4:41
 **/
public class No24SwapNodesinPairs {

    public ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        root.next = head;

        ListNode first = head;
        ListNode second = head;

        while(root.next!=null&&root.next.next!=null){
            first = root.next;
            second = first.next;

            first.next = second.next;
            second.next = first;

            root.next = second;
            root = root.next.next;
        }

        return dummy.next;
    }
}
