package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No19RemoveNthNodeFromEndofList
 * @Description:
 * @date 2017年04月26日 下午2:46
 **/
public class No19RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;

        ListNode fast = head;
        for(int i = 0;i<n-1;i++){
            if(fast.next!=null){
                fast = fast.next;
            }else{
                return null;
            }
        }


        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }


        if(slow.next!=null){
            ListNode tmp = slow.next;
            slow.next = tmp.next;
            slow.val = tmp.val;
        }else if(slow==head){
            return null;
        }else {
            ListNode tmp = head;
            while(tmp.next!=slow){
                tmp = tmp.next;
            }
            tmp.next=null;
            return head;
        }


        return head;
    }
}
