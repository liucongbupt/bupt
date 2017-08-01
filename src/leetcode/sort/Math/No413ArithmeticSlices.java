package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No413ArithmeticSlices
 * @Description:
 * @date 2016年11月22日 下午3:04
 **/

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 Subscribe to see which companies asked this question

 Hide Tags Dynamic Programming leetcode.Math
 Hide Similar Problems (H) Arithmetic Slices II - Subsequence

 */
public class No413ArithmeticSlices {
    public No413ArithmeticSlices() {

    }

    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int addend = 0;

        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                count += ++addend;
            else
                addend = 0;

        return count;
    }

    public static void main(String[] args) {

    }
}
