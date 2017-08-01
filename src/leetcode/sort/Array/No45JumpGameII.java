package leetcode.sort.Array; /**
 * @author liucong
 * @ClassName: No45JumpGameII
 * @Description:
 * @date 2016年10月12日 11:25 AM
 **/

/**
 * Given an leetcode.Array of non-negative integers, you are initially positioned at the first index of the leetcode.Array.
 * <p>
 * Each element in the leetcode.Array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given leetcode.Array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags leetcode.Array Greedy
 */
public class No45JumpGameII {
    public No45JumpGameII() {

    }

    public int jump(int[] nums) {
        int ret = 0;
        int curMax = 0;
        int curRch = 0;
        for(int i = 0; i < nums.length; i ++)
        {
            if(curRch < i)
            {
                ret ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        return ret;
    }

    public static void main(String[] args) {
        No45JumpGameII jg = new No45JumpGameII();
        int a = jg.jump(new int[]{1, 2, 3, 4});
        System.out.println(a);
    }
}
