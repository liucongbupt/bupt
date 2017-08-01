package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No153FindMinimuminRotatedSortedArray
 * @Description:
 * @date 2017年04月26日 下午5:35
 **/
public class No153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int idx1 = 0;
        int idx2 = nums.length-1;
        int mid = idx1;
        while(nums[idx1]>nums[idx2]){
            if(idx2-idx1==1){
                mid = idx2;
                break;
            }

            mid = (idx2-idx1)/2+idx1;

            if(nums[mid]>nums[idx1]){
                idx1 = mid;
            }else if(nums[mid]<nums[idx2]){
                idx2 = mid;
            }

        }
        return nums[mid];
    }

    public int findMinn(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = start;
        while(nums[start]>nums[end]){
            if(end-start==1){
                mid = end;
                break;
            }

            mid = (start+end)/2;
            if(nums[mid]<nums[end]){//you bian you xu
                end = mid;
            }else {
                start = mid;
            }

        }
        return nums[mid];
    }
}
