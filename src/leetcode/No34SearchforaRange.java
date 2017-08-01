package leetcode;

/**
 * Created by liucong on 2017/5/9.
 */
public class No34SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        int[] rtn = new int[]{-1,-1};
        if(nums==null||nums.length==0)
            return rtn;
        int start  = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        if(nums[start]!=target) return rtn;
        else{
            rtn[0] = start;
        }

        end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2+1;

            if (nums[mid]>target){
                end = mid-1;
            }else{
                start = mid;
            }
        }
        rtn[1]=start;
        return rtn;
    }

    public static void main(String[] args) {
        No34SearchforaRange test = new No34SearchforaRange();
        test.searchRange(new int[]{5,7,7,8,8,10},8);
        test.searchRange(new int[]{5,7,7,8,10},8);
    }
}
