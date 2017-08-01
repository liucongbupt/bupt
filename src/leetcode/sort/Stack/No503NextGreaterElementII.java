package leetcode.sort.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No503NextGreaterElementII
 * @Description:
 * @date 2017年04月12日 上午11:16
 **/
public class No503NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length * 2-1; i++) {
            while (!s.isEmpty() && nums[i % nums.length] > nums[s.peek()])
                map.put(s.pop(), nums[i % nums.length]);
            if (i < nums.length)
                s.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(i, -1);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = new int[]{100,1,11,1,120,111,123,1,-1,-100};
        nextGreaterElements(test);
    }
}
