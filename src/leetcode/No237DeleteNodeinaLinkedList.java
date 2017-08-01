package leetcode;

/**
 * Created by liucong on 2017/5/10.
 */
public class No237DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
        return;
    }
}
