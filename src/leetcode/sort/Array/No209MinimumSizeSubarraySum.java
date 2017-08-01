package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No209MinimumSizeSubarraySum
 * @Description:
 * @date 2017年03月02日 上午9:28
 **/

/**
 *Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 Credits:
 Special thanks to @Freezen for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array Two Pointers Binary Search
 Hide Similar Problems (H) Minimum Window Substring (M) Maximum Size Subarray Sum Equals k

 */
public class No209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int rtn = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cut =0;
            int temp =0;
            for (int j = i; j < nums.length; j++) {

                if((temp+nums[j])<s){
                    temp+=nums[j];
                    cut++;
                }else{
                    cut++;
                    rtn = Math.min(cut,rtn);
                    break;
                }
            }
        }
        if(rtn==Integer.MAX_VALUE) return 0;
        return rtn;
    }

    public static void main(String[] args) {
        No209MinimumSizeSubarraySum s = new No209MinimumSizeSubarraySum();
        System.out.println(s.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
