package leetcode.sort.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: No416PartitionEqualSubsetSum
 * @Description:
 * @date 2017年03月26日 下午4:55
 **/
public class No416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums==null||nums.length==0)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum%2!=0) return false;
        sum<<=1;
        // dp def
        boolean[] dp = new boolean[sum + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[sum];
    }
}
