package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode root = head;
        dummy.next = root;
        ListNode prev = dummy;
        while(root!=null){
            if(root.val==val){
                prev.next = root.next;
            }else{
                prev = root;
            }
            root = root.next;
        }
        return dummy.next;
    }
}
