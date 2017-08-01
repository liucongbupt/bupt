package leetcode;

import java.util.Random;

/**
 * Created by liucong on 2017/5/10.
 */
public class No382LinkedListRandomNode {


    public class Solution {
        ListNode h;

        Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            h = head;
            random= new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode c = h;
            int r = c.val;
            for(int i=1;c.next != null;i++){
                c = c.next;
                if(random.nextInt(i + 1) == i) r = c.val;
            }

            return r;
        }
    }
}
