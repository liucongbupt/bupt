package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No485MaxConsecutiveOnes
 * @Description:
 * @date 2017年02月26日 下午9:16
 **/
public class No485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int cnt = 0;
        int max = 0;
        while(i<nums.length){
            if(nums[i]==1){
                cnt=cnt+1;
                max=Math.max(max,cnt);
            }else{
                cnt=0;
            }
            i++;
        }
        return max;
    }
}
