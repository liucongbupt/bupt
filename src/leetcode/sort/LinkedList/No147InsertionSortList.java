package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No147InsertionSortList
 * @Description:
 * @date 2017年03月13日 下午5:36
 **/

/**
 *
 */
public class No147InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
//        // 所以这里不需要dummy.next = head;
//
//        while (head != null) {
//            ListNode node = dummy;
//            while (node.next != null && node.next.val < head.val) {
//                node = node.next;
//            }
//            ListNode temp = head.next;
//            head.next = node.next;
//            node.next = head;
//            head = temp;
//        }
//
//        return dummy.next;
        ListNode dummy = new ListNode(0);

        while(head!=null){
            ListNode node  = dummy;
            while(node.next!=null&&node.next.val<head.val)
                node=node.next;
            ListNode temp = head.next;
            head.next = node.next;
            node.next=head;
            head=temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(1);
        a.next=b;
        b.next=c;
        c.next=d;
        insertionSortList(a);
    }

}
