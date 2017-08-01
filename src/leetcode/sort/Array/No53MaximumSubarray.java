package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: leetcode.DynamicProgramming.No53MaximumSubarray
 * @Description:
 * @date 2016年10月12日 9:18 AM
 **/
public class No53MaximumSubarray {
    public No53MaximumSubarray() {
    }
    //Kadane
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

    //效率不高
    public int mmaxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }
    public static void main(String[] args) {

    }
}
