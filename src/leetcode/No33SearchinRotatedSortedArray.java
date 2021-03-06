package leetcode; /**
 * @author liucong
 * @ClassName: leetcode.No33SearchinRotatedSortedArray
 * @Description:
 * @date 2017年02月27日 下午8:05
 **/

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Subscribe to see which companies asked this question.*
 */
public class No33SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]<nums[right]){
                if(nums[mid]<target&&nums[right]>=target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;

    }

    public int searchs(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(left > right) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if(target == nums[mid]){
            return mid;
        }
        if(nums[mid] < nums[right]) { //right half sorted
            if(nums[mid] < target && target <= nums[right]){
                return binarySearch(nums, mid+1, right, target);
            }else {
                return binarySearch(nums, left, mid-1, target);
            }
        }else { //left half sorted
            if(nums[left] <= target && target < nums[mid]){
                return binarySearch(nums, left, mid-1, target);
            }else{
                return binarySearch(nums, mid+1, right, target);
            }
        }
    }

}
