package offer;

/**
 * @author liucong
 * @ClassName: No26
 * @Description:
 * @date 2017年04月01日 下午8:58
 **/
public class No26 {
    /**
     * 复杂链表结点
     */
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }
    public static ComplexListNode clone(ComplexListNode head){
        cloneNodes(head);
        connectSiblings(head);
        return reconnectNodes(head);
    }

    public static void cloneNodes(ComplexListNode head){
        ComplexListNode node  = head;
        while (node!=null){
            ComplexListNode cloned = new ComplexListNode();
            cloned.value = node.value;
            cloned.next = node.next;
            cloned.sibling = null;
            node.next = cloned;
            node=cloned.next;
        }
    }

    public static void connectSiblings(ComplexListNode head){
        ComplexListNode node  = head;
        while (node!=null){
            ComplexListNode cloned = node.next;
            if(node.sibling!=null){
                cloned.sibling = node.sibling.next;
            }
            node=cloned.next;
        }
    }

    public static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode node = head;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;

        if(node!=null){
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while (node!=null){
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }
}
