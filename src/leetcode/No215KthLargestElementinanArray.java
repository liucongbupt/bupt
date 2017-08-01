package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liucong
 * @ClassName: leetcode.No215KthLargestElementinanArray
 * @Description:
 * @date 2017年04月24日 下午8:08
 **/
public class No215KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int rtn = 0;
        for (int i = 0; i < k; i++) {
            rtn=queue.poll();
        }
        return rtn;
    }
}
