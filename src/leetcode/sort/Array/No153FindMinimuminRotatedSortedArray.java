package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No153FindMinimuminRotatedSortedArray
 * @Description:
 * @date 2017年03月01日 下午4:00
 **/

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Subscribe to see which companies asked this question.

 Hide Tags leetcode.Array Binary Search
 Hide Similar Problems (M) Search in Rotated Sorted leetcode.Array (H) Find Minimum in Rotated Sorted leetcode.Array II

 */
public class No153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;

            if(left<=right){
                min = Math.min(min,nums[mid]);

                if(nums[mid]<nums[right]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }
        }
        return min;
    }

    public int findMinn(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) { //注意这里和普通的二分查找不同，这里是start < end不是 start <= end.
            mid = start + (end - start)/2;
            if (nums[mid] > nums[end])
                start = mid + 1; //此时可以扔掉mid的值
            else
                end = mid;//此时不能扔掉mid的值
        }
        return nums[end];
    }

}
