package leetcode;

/**
 * Created by liucong on 2017/5/8.
 */
public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int begin=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val) nums[begin++]=nums[i];
        }
        return begin;
    }

}
