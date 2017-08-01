package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No83RemoveDuplicatesfromSortedList
 * @Description:
 * @date 2017年03月14日 上午11:27
 **/

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class No83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
