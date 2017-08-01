package leetcode.sort.Array; /**
 * Created by liucong on 9/28/16.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class No35SearchInsertPosition {

    public No35SearchInsertPosition() {

    }
    public  int searchInsert(int[] nums, int target) {
        return bSearch(nums,nums.length, target);
    }
    public int bSearch(int[] a, int n, int target) {
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high)>>1;
            if(a[mid] == target)
                return mid;
            else if(a[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        if(high < 0) return 0;
        if(low >= n) return n;
        return low;
    }
    public static void main(String[] args) {

        No35SearchInsertPosition a = new No35SearchInsertPosition();
        int[] b = new int[]{1,2,3,4};
        System.out.println(a.searchInsert(b,0));
    }
}
