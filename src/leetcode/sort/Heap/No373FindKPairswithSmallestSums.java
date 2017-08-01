package leetcode.sort.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liucong
 * @ClassName: No373FindKPairswithSmallestSums
 * @Description:
 * @date 2017年04月12日 下午3:43
 **/
public class No373FindKPairswithSmallestSums {
//    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<int[]> list = new ArrayList<>();
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (o1[0]+o1[1]-o2[0]-o2[1]);
//            }
//        });
//
//        for (int i = 0; i <nums1.length&&i<k ; i++) {
//            for (int j = 0; j <nums2.length&&j<k ; j++) {
//                queue.add(new int[]{nums1[i],nums2[j]});
//            }
//        }
//
//        while (!queue.isEmpty()&&k>0){
//            list.add(queue.poll());
//            k--;
//        }
//        return list;
//    }


    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return list;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for (int i = 0; i < nums2.length && i < k; i++) {
            queue.add(new Tuple(0, i, nums1[0] + nums2[i]));
        }
        while(k-- > 0 && !queue.isEmpty()){
            Tuple cur = queue.poll();
            list.add(new int[]{nums1[cur.x], nums2[cur.y]});
            if(cur.x == nums1.length-1) continue;
            queue.offer(new Tuple(cur.x+1,cur.y,nums1[cur.x+1]+nums2[cur.y]));
        }
        return list;
    }

    static class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 6};
        int[] b = new int[]{3, 5, 7, 9};
        kSmallestPairs(a, b, 3);
    }
}
