package leetcode;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: leetcode.No16ThreeSumCloseest
 * @Description:
 * @date 2017年04月19日 上午9:45
 **/
public class No16ThreeSumCloseest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int rtn = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;

            while(l<r){
                int sum = nums[l]+nums[r]+nums[i];
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    l++;
                }else{
                    r--;
                }

                if(Math.abs(sum-target)<diff){
                    rtn = sum;
                    diff = Math.abs(sum-target);
                }
            }
        }
        return rtn;
    }
}
