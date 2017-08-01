package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No154FindMinimuminRotatedSortedArrayII
 * @Description:
 * @date 2017年04月26日 下午6:47
 **/
public class No154FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = lo;
        while(nums[lo]>=nums[hi]){
            if(hi-lo==1){
                return nums[hi];
            }
            mid = (hi-lo)/2+lo;
            if(nums[mid]==nums[lo]&&nums[mid]==nums[hi]){
                return min(nums,lo,hi);
            }

            if(nums[mid]>=nums[lo]){
                lo = mid;
            }else if(nums[mid]<=nums[hi]){
                hi = mid;
            }
        }
        return nums[mid];
    }

    int min(int[] numbers,int lo,int hi){
        int result = numbers[lo];
        for(int i = lo+1;i<=hi;i++){
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}
