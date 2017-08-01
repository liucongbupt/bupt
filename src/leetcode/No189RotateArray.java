package leetcode;

/**
 * Created by liucong on 2017/5/9.
 */
public class No189RotateArray {
    public void rotate(int[] nums, int k) {

        k %= nums.length;
        int len = nums.length;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
