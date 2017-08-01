package leetcode.sort.DFS.TwoPointer;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No532KdiffPairsinanArray
 * @Description:
 * @date 2017年03月27日 上午10:53
 **/
public class No532KdiffPairsinanArray {
    public static  int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int rtn = 0;
        if (k < 0)
            return rtn;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                if (map.containsKey(nums[i])) {
                    int count = map.get(nums[i]);
                    if (count == 1) rtn++;
                    map.put(nums[i], ++count);
                } else {
                    map.put(nums[i], 1);
                }
            } else {
                if (map.containsKey(nums[i])) {
                    int count = map.get(nums[i]);
                    map.put(nums[i], count++);
                } else {
                    if (map.containsKey(nums[i] - k))
                        rtn++;
                    map.put(nums[i], 1);
                }
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println();
        int a = findPairs(new int[]{1,1,1,2,2},1);
        System.out.println(a);
    }
}
