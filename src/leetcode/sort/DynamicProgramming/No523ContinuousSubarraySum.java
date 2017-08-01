package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No523ContinuousSubarraySum
 * @Description:
 * @date 2017年04月09日 下午8:34
 **/
public class No523ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
//        if (nums==null||nums.length<2)
//            return false;
//        if (k==0){
//            for (int j = 0; j < nums.length-1; j++) {
//                if (nums[j]==0&&nums[j+1]==0)
//                    return true;
//            }
//            return false;
//        }
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][i]=nums[i];
//            for (int j = i+1; j <nums.length ; j++) {
//                dp[i][j]=dp[i][j-1]+nums[j];
//                if (dp[i][j]%k==0)
//                    return true;
//            }
//        }
//        return false;
        if (nums==null||nums.length<2)
            return false;
        if (k==0){
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j]+nums[j+1]==0)
                    return true;
            }
            return false;
        }
        int n = nums.length;
        int level = 2;
        int sum = 0;
        while (n!=1){
            int start = 0;
            int end = level;
            for (int i = 0; i < level; i++) {
                sum+=nums[i];
            }
            if (sum%k==0) return true;
            for (; end < nums.length; start++,end++) {
                sum=sum+nums[end]-nums[start];
                if (sum%k==0) return true;
            }
            level++;
            n--;
            sum=0;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},6));
//        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},5));
        System.out.println(checkSubarraySum(new int[]{1,2,3},6));
    }
}
