package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No376WiggleSubsequence
 * @Description:
 * @date 2017年04月08日 下午2:22
 **/
public class No376WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length==1||nums.length==0)
            return nums.length;
        int k = 0;
        while (k<nums.length-1&&nums[k]==nums[k+1]){
            k++;
        }
        if (k==nums.length-1)
            return 1;
        int rtn = 2;
        boolean up = nums[k]<nums[k+1];
        for (int i = k+1; i <nums.length-1 ; i++) {
            if (up&&nums[i+1]<nums[i]){
                up=!up;
                nums[rtn]=nums[i+1];
                rtn++;
            }else if(!up&&nums[i+1]>nums[i]){
                up=!up;
                nums[rtn]=nums[i+1];
                rtn++;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println( wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println( wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println( wiggleMaxLength(new int[]{1,2,3,4,5,6}));

    }
}
