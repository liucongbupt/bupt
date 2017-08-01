package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No81SearchinRotatedSortedArrayII
 * @Description:
 * @date 2017年04月26日 下午7:39
 **/
public class No81SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (right-left)/2+left;

            if(nums[mid]==target){
                return true;
            }

            if(nums[mid]<nums[right]){
                if(nums[mid]<target&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else if(nums[mid]>nums[right]){
                if(nums[left]<=target&&target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }

            }else{
                right--;
            }

        }

        return false;
    }



}
