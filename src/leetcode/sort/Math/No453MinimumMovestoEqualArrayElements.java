package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No453MinimumMovestoEqualArrayElements
 * @Description:
 * @date 2016年11月23日 下午3:30
 **/

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math
 Hide Similar Problems (M) Minimum Moves to Equal leetcode.Array Elements II


 */
public class No453MinimumMovestoEqualArrayElements {
    public No453MinimumMovestoEqualArrayElements() {
    }
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int rtn = 0;
        for (int i = 1; i < n; i++) {
            rtn += nums[i]-nums[0];
        }
        return rtn;
    }
    public static void main(String[] args) {

    }
}
