package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No45JumpGameII
 * @Description:
 * @date 2017年04月27日 下午11:30
 **/
public class No45JumpGameII {
    public int jump(int[] nums) {
        int rtn = 0;
        int curMax = 0;
        int curRch = 0;
        for(int i =0;i<nums.length;i++){
            if(curRch<i){
                rtn++;
                curRch=curMax;
            }
            curMax=Math.max(curMax,nums[i]+i);
        }
        return rtn;

    }
}
