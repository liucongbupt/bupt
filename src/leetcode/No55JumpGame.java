package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No55JumpGame
 * @Description:
 * @date 2017年04月27日 下午11:16
 **/
public class No55JumpGame {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int max = 0;
        for(int i = 0; i<=max && i<nums.length-1;i++){
            max = Math.max(max,nums[i]+i);
        }
        return max >= nums.length-1;

    }
}
