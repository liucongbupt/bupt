package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No198HouseRobber
 * @Description:
 * @date 2017年04月20日 下午3:53
 **/
public class No198HouseRobber {

    public static int[] dp;
    public int solve(int idx,int[] nums){
        if(idx<0)
            return 0;
        if(dp[idx]>=0){
            return dp[idx];
        }

        dp[idx]=Math.max(nums[idx]+solve(idx-2,nums),
                solve(idx-1,nums));
        return dp[idx];
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i]=-1;
        }
        return solve(nums.length-1,nums);
    }

    public int rob1(int[] nums) {
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
