package offer;

/**
 * @author liucong
 * @ClassName: No16
 * @Description:
 * @date 2017年03月31日 下午3:13
 **/
public class No16 {
    public static class ListNode{
        int value;
        ListNode next;
    }
    public ListNode ReverseList(ListNode head){
        ListNode reversedHead = null;
        ListNode node = head;
        ListNode prev = null;
        while (head!=null){
            ListNode next = node.next;

            if(next==null)
                reversedHead = node;
            node.next = prev;

            prev = node;
            node=next;
        }
        return reversedHead;
    }
    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     *
     * @param head 链表的头结点
     * @return 反转后的链表的头结点
     */
    public static ListNode reverseList(ListNode head) {
        // 创建一个临时结点，当作尾插法的逻辑头结点
        ListNode root = new ListNode();
        // 逻辑头结点点的下一个结点为空
        root.next = null;

        // 用于记录要处理的下一个结点
        ListNode next;
        // 当前处理的结点不为空
        while (head != null) {
            // 记录要处理的下一个结点
            next = head.next;
            // 当前结点的下一个结点指向逻辑头结点的下一个结点
            head.next = root.next;
            // 逻辑头结点的下一个结点指向当前处理的结点
            root.next = head;
            // 上面操作完成了一个结点的头插

            // 当前结点指向下一个要处理的结点
            head = next;
        }

        // 逻辑头结点的下一个结点就是返回后的头结点
        return root.next;
    }
}
