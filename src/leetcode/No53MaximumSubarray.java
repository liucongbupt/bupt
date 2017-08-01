package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No53MaximumSubarray
 * @Description:
 * @date 2017年04月23日 上午9:40
 **/
public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<n;i++){
            dp[i] = nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum = nums[i];
            }else{
                sum+=nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;

    }
}
