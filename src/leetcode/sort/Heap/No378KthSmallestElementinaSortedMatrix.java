package leetcode.sort.Heap;

import com.sun.xml.internal.ws.util.Pool;

import java.util.PriorityQueue;

/**
 * @author liucong
 * @ClassName: No378KthSmallestElementinaSortedMatrix
 * @Description:
 * @date 2017年04月12日 下午3:58
 **/
public class No378KthSmallestElementinaSortedMatrix {
    class tuple implements Comparable<tuple>{
        int x;
        int y;
        int val;

        public tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (tuple that) {
            return this.val - that.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<tuple> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new tuple(0,i,matrix[0][i]));
        }

        for (int i = 0; i <k-1 ; i++) {
            tuple t = queue.poll();
            if (t.x==matrix.length-1) continue;
            queue.add(new tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return queue.poll().val;
    }
}
