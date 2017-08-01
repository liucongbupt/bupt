package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No82RemoveDuplicatesfromSortedListII
 * @Description:
 * @date 2017年03月14日 上午11:29
 **/
public class No82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
//        slow.next = fast;
//        while(fast != null) {
//            while (fast.next != null && fast.val == fast.next.val) {
//                fast = fast.next;    //while loop to find the last node of the dups.
//            }
//            if (slow.next != fast) { //duplicates detected.
//                slow.next = fast.next; //remove the dups.
//                fast = slow.next;     //reposition the fast pointer.
//            } else { //no dup, move down both pointer.
//                slow = slow.next;
//                fast = fast.next;
//            }
//
//        }
//        return dummy.next;





        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next=fast;
        while (fast!=null){
            while(fast.next!=null&&fast.val==fast.next.val){
                fast=fast.next;
            }
            if(slow.next!=fast){
                slow.next=fast.next;
                fast=slow.next;
            }else{
                slow=slow.next;
                fast=fast.next;
            }
        }
        return dummy.next;
    }
}
