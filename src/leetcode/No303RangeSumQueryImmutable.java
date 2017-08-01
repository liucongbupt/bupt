package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No303RangeSumQueryImmutable
 * @Description:
 * @date 2017年04月22日 下午3:04
 **/
public class No303RangeSumQueryImmutable {
    public class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length];
            for(int i = 0;i<nums.length;i++){
                if(i==0)
                    dp[i]=nums[i];
                else
                    dp[i]=dp[i-1]+nums[i];


            }
        }

        public int sumRange(int i, int j) {
            if(i==0)
                return dp[j];
            else
                return dp[j]-dp[i-1];
        }
    }
}
