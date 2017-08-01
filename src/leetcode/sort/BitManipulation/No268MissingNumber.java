package leetcode.sort.BitManipulation; /**
 * @author liucong
 * @ClassName: leetcode.Array.No268MissingNumber
 * @Description:
 * @date 2016年11月14日 上午10:08
 **/

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags leetcode.Array leetcode.Math Bit Manipulation
 Hide Similar Problems (H) First Missing Positive (E) Single Number (H) Find the Duplicate Number

 */
public class No268MissingNumber {
    public No268MissingNumber() {
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int counter;
        for (counter = 0; counter < nums.length; counter++) {
            if (counter != nums[counter]) {
                return counter;
            }
        }
        return counter;
    }

    public int missingNumberEx(int[] nums) {
        int n = nums.length;
        int rtn = (n+1)*n/2;
        for (int i = 0; i < nums.length; i++) {
            rtn -= nums[i];
        }
        return rtn;
    }

    public static void main(String[] args) {

    }
}
