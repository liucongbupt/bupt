package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No26RemoveDuplicatesfromSortedArray
 * @Description:
 * @date 2017年05月03日 下午7:06
 **/
public class No26RemoveDuplicatesfromSortedArray {

    public int removeDuplicatess(int[] nums) {
        int i = nums.length > 0 ? 1: 0;
        for(int n:nums)
            if(n>nums[i-1])
                nums[i++] = n;
        return i;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int begin = 1;
        int val = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[begin++]=nums[i];
                val = nums[i];
            }else{
                continue;
            }
        }
        return begin;
    }
}
