package offer;

import java.util.List;

/**
 * @author liucong
 * @ClassName: No13RemoveKthNode
 * @Description:
 * @date 2017年03月31日 上午11:25
 **/
public class No13RemoveKthNode {
    public static class ListNode{
        int value;
        ListNode next;

        public ListNode() {
        }
    }
    public static ListNode deleteNode(ListNode head,ListNode toBeDeleted){
        if(head==null||toBeDeleted==null)
            return head;
        if(toBeDeleted.next!=null){
            ListNode next = toBeDeleted.next;
            toBeDeleted.value=next.value;
            toBeDeleted.next=next.next;
        }else if(head==toBeDeleted){
            head=null;
        }else {
            ListNode node = head;
            while (node.next!=toBeDeleted){
                node=node.next;
            }
            node.next=null;
        }
        return head;
    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {


        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = deleteNode(head, head); // 删除头结点
        printList(head);
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
    }
}
