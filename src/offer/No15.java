package offer;

/**
 * @author liucong
 * @ClassName: No15
 * @Description:
 * @date 2017年03月31日 下午3:08
 **/
public class No15 {

    public ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k-1; i++) {
            if(fast.next!=null){
                fast=fast.next;
            }else {
                return null;
            }
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
