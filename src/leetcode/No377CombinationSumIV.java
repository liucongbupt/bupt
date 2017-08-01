package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No377CombinationSumIV
 * @Description:
 * @date 2017年04月20日 下午3:20
 **/
public class No377CombinationSumIV {
    //    TLM
//      int rtn = 0;
//    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        backtarck(nums,target);
//        return rtn;
//    }
//    public void backtarck(int[] nums,int target){
//        if (target<0){
//            return;
//        }else if(target==0){
//            rtn++;
//            return;
//        }else{
//            for (int i = 0; i <nums.length ; i++) {
//                backtarck(nums,target-nums[i]);
//            }
//        }
//    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i-nums[j]>=0)
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        No377CombinationSumIV test = new No377CombinationSumIV();
        test.combinationSum4(new int[]{1, 2, 3}, 4);
    }

}
