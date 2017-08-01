package leetcode.sort.DynamicProgramming;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No300LongestIncreasingSubsequence
 * @Description:
 * @date 2017年04月08日 上午10:03
 **/
public class No300LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length<1)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n ; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }


    public int lengthOfLISS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

    }
}
