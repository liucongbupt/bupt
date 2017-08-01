package leetcode; /**
 * @author liucong
 * @ClassName: leetcode.No287FindtheDuplicateNumber
 * @Description:
 * @date 2017年02月28日 下午8:42
 **/

/**
 *Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question.

 Hide Tags Binary Search leetcode.Array Two Pointers
 Hide Similar Problems (H) First Missing Positive (E) Single Number (M) Linked List Cycle II (E) Missing Number

 */
public class No287FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max){
            // 找到中间那个数
            int mid = min + (max - min) / 2;
            int cnt = 0;
            // 计算总数组中有多少个数小于等于中间数
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if(cnt > mid){
                max = mid - 1;
                // 否则后半部分必有重复
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public int findDuplicatee(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }

    public int findDuplicateee(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                return index+1;
            nums[index] = -nums[index];
        }
        return 0;
    }
}
