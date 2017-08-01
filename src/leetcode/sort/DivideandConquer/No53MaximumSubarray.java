package leetcode.sort.DivideandConquer;

/**
 * @author liucong
 * @ClassName: leetcode.DynamicProgramming.No53MaximumSubarray
 * @Description:
 * @date 2016年10月12日 9:18 AM
 **/
public class No53MaximumSubarray {
    public No53MaximumSubarray() {
    }
    public int maxSubArray(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum<0){
                sum = 0;
            }
            sum+=nums[i];
            max=Math.max(max,sum);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
