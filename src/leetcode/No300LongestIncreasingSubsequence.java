package leetcode;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: leetcode.No300LongestIncreasingSubsequence
 * @Description:
 * @date 2017年04月21日 上午11:33
 **/
public class No300LongestIncreasingSubsequence {

    public int lengthOfLIS2(int[] nums) {
        if (nums==null||nums.length<1)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = -1;
        for(int i =0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
