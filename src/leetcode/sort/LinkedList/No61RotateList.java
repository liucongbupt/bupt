package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No61RotateList
 * @Description:
 * @date 2017年03月14日 下午3:56
 **/
public class No61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || k == 0) return head;
//        int size = 1;
//        ListNode node = head;
//        while(node.next != null) {
//            node = node.next;
//            size++;
//        }
//        node.next = head;
//        int n = size - k%size;
//        for(int i=0; i<n; i++) {
//            node = node.next;
//        }
//        ListNode h = node.next;
//        node.next = null;
        if(head==null||k==0) return head;
        int size = 1;
        ListNode node =head;
        while(node.next!=null){
            node=node.next;
            size++;
        }
        node.next=head;
        int n = size-k%size;
        for (int i = 0; i < n; i++) {
            node=node.next;
        }
        ListNode h = node.next;
        node.next=null;
        return h;

    }
}
