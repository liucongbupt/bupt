package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No206ReverseLinkedList
 * @Description:
 * @date 2017年04月24日 上午11:41
 **/
public class No206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
