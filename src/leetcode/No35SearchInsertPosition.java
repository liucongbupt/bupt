package leetcode;

/**
 * Created by liucong on 2017/5/9.
 */
public class No35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target){
                lo = mid+1;
            }else if(nums[mid]>target){
                hi = mid -1;
            }
        }
        return lo;
    }
}
