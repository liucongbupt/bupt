package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No462MinimumMovestoEqualArrayElementsII
 * @Description:
 * @date 2016年11月23日 下午5:29
 **/

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math
 Hide Similar Problems (H) Best Meeting Point (E) Minimum Moves to Equal leetcode.Array Elements

 */
public class No462MinimumMovestoEqualArrayElementsII {
    public No462MinimumMovestoEqualArrayElementsII() {
    }
    public int minMoves2(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0, j = nums.length - 1;
//        int ret = 0;
//        while (i < j) {
//            ret += nums[j] - nums[i];
//            i++;
//            j--;
//        }
//        return ret;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int middle = sum/nums.length;
        int rtn=0;
        for (int i = 0; i < nums.length; i++) {
            rtn+=Math.abs(nums[i]-middle);
        }
        return rtn;
    }
    public static void main(String[] args) {

    }
}
