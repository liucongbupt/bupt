package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No138CopyListwithRandomPointer
 * @Description:
 * @date 2017年03月14日 上午10:46
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class No138CopyListwithRandomPointer {
    class RandomListNode {
             int label;
             RandomListNode next, random;
             RandomListNode(int x) { this.label = x; }
         };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode p = head;

        // copy every node and insert to list
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // break list to two
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }

        return newHead;
    }

    public RandomListNode copyRandomListt(RandomListNode head) {
        if(head==null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head,newHead);

        p=p.next;
        while (p!=null){
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p,temp);
            q.next = temp;
            q=temp;
            p=p.next;
        }

        p=head;
        q=newHead;
        while (p!=null){
            if(p.random!=null){
                q.random = map.get(p.random);
            }else{
                q.random=null;
            }
            p=p.next;
            q=q.next;
        }
        return newHead;
//        if (head == null)
//            return null;
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//        RandomListNode newHead = new RandomListNode(head.label);
//
//        RandomListNode p = head;
//        RandomListNode q = newHead;
//        map.put(head, newHead);
//
//        p = p.next;
//        while (p != null) {
//            RandomListNode temp = new RandomListNode(p.label);
//            map.put(p, temp);
//            q.next = temp;
//            q = temp;
//            p = p.next;
//        }
//
//        p = head;
//        q = newHead;
//        while (p != null) {
//            if (p.random != null)
//                q.random = map.get(p.random);
//            else
//                q.random = null;
//
//            p = p.next;
//            q = q.next;
//        }
//
//        return newHead;
    }
}
