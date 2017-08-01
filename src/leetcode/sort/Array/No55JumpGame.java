package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No55JumpGame
 * @Description:
 * @date 2016年10月12日 10:52 AM
 * Given an leetcode.Array of non-negative integers, you are initially positioned at the first index of the leetcode.Array.
 * Each element in the leetcode.Array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 **/
public class No55JumpGame {
    public No55JumpGame() {
    }

    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }

        int max = 0, i = 0;
//        for (int j = 0; j < nums.length-1; j++) {
//            max = leetcode.Math.max(max,nums[i]+i);
//        }
//        return max==nums.length-1;
        for(i = 0; i <= max && i < nums.length; i++){
            max = Math.max(max, nums[i] + i);
        }
        return i == nums.length;
    }
    public static void main(String[] args) {

    }
}
