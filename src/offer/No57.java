package offer;

/**
 * @author liucong
 * @ClassName: No57
 * @Description:
 * @date 2017年04月05日 上午11:29
 **/
public class No57 {
    static ListNode deleteDuplication(ListNode head){
        if (head==null)
            return null;

        ListNode root  = new ListNode(0);
        root.next=head;
        ListNode prev = root;
        ListNode node = head;
        while (node!=null&&node.next!=null){
            if (node.val==node.next.val){
                while (node.next!=null&&node.next.val==node.val)
                    node=node.next;

                prev.next=node.next;
            }else {
                prev.next=node;
                node=node.next;
            }
        }
        return root.next;

    }
}
