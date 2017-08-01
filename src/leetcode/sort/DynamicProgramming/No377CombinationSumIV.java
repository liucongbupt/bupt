package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No377CombinationSumIV
 * @Description:
 * @date 2017年04月08日 下午8:23
 **/
public class No377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums==null||nums.length==0)
            return 0;
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i = 1; i <= target ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if (nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
