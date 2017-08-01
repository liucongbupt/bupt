package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No86PartitionList
 * @Description:
 * @date 2017年03月14日 上午11:44
 **/
public class No86PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode q=l2,p=l1;
        while(head!=null){
            if(head.val<x){
                l1.next=new ListNode(head.val);
                l1=l1.next;
            }else{
                l2.next = new ListNode(head.val);
                l2=l2.next;
            }
            head=head.next;
        }
        l1.next=q.next;
        return p.next;
        /**
         *
         * ListNode l1 = new ListNode(0);
         ListNode l2 = new ListNode(0);
         ListNode q=l2,p=l1;
         while(head!=null){

         if(head.val<x){
         l1.next=head;
         l1=l1.next;
         }else{
         l2.next = head;
         l2=l2.next;
         }
         head=head.next;
         }
         l2.next=null;
         l1.next=q.next;
         return p.next;
         */
    }
}
