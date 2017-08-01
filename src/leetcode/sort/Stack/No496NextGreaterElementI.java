package leetcode.sort.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No496NextGreaterElementI
 * @Description:
 * @date 2017年04月11日 下午9:20
 **/
public class No496NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int n:nums
             ) {
            while (!s.isEmpty()&&n>s.peek())
                map.put(s.pop(),n);
            s.push(n);
        }

        for (int i = 0; i < findNums.length; i++) {
            findNums[i]=map.getOrDefault(findNums[i],-1);
        }
        return findNums;
    }
}
