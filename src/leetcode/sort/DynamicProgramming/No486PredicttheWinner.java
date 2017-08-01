package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No486PredicttheWinner
 * @Description:
 * @date 2017年04月09日 下午9:10
 **/
public class No486PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums==null) return true;
        int n = nums.length;
        if((n&1)==0) return true;
        int[] dp = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i; j < n; j++) {
                if (i==j){
                    dp[i]=nums[i];
                }else {
                    dp[j]=Math.max(nums[i]-dp[j],nums[j]-dp[j-1]);
                }
            }
        }
        return dp[n-1]>0;
    }
}
