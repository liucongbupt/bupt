package leetcode.sort.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liucong
 * @ClassName: No525ContiguousArray
 * @Description:
 * @date 2017年03月30日 下午4:29
 **/
public class No525ContiguousArray {
    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                nums[i]=-1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0,max=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }else {
            map.put(sum,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = findMaxLength(new int[]{0,1,1,1,0,0});
        System.out.println(i);
    }
}
