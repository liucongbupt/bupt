package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liucong
 * @ClassName: leetcode.No23MergekSortedLists
 * @Description:
 * @date 2017年04月24日 上午11:16
 **/
public class No23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode root = dummy;

        for (ListNode list:lists
             ) {
            if (list!=null)
                queue.add(list);
        }

        while (!queue.isEmpty()){
            root.next = queue.poll();
            root=root.next;

            if (root.next!=null){
                queue.add(root.next);
            }
        }
        return dummy.next;
    }
}
