package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No152MaximumProductSubarray
 * @Description:
 * @date 2017年03月01日 下午2:43
 **/

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array Dynamic Programming
 Hide Similar Problems (E) Maximum Subarray (E) House Robber (M) Product of leetcode.Array Except Self

 */
public class No152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];

        int global = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int a=max*nums[i];
            int b=min*nums[i];

            max = Math.max(nums[i],Math.max(a,b));
            min = Math.min(nums[i],Math.min(a,b));

            global = Math.max(max, global);
        }
        return global;
    }
//slow
    public int maxProductt(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

}
