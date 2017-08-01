package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No357CountNumberswithUniqueDigits
 * @Description:
 * @date 2016年11月15日 下午4:20
 **/

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * <p>
 * Hint:
 * <p>
 * A direct way is to use the backtracking approach.
 * leetcode.Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.Show More Hint
 * Credits:
 * Special thanks to @memoryless for adding this problem and creating all leetcode.Sort cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Dynamic Programming leetcode.Backtracking leetcode.Math
 */
public class No357CountNumberswithUniqueDigits {

    public No357CountNumberswithUniqueDigits() {

    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int rtn = 10;
        int current = 1;

        while (current < n && current < 10) {
            int temp = 9;
            for (int i = 0; i < current; i++) {
                temp *= 9 - i;
            }
            rtn += temp;
            current++;
        }
        return rtn;
    }

    public static void main(String[] args) {

    }
}
