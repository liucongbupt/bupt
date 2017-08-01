package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA<lenB) return getIntersectionNode(headB,headA);

        int step = lenA-lenB;
        while (step!=0){
            headA = headA.next;
            step--;
        }

        while (headA!=null&&headB!=null&&headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int getLength(ListNode head){
        int rtn = 0 ;
        while (head!=null){
            head=head.next;
            rtn++;
        }
        return rtn;
    }
}
