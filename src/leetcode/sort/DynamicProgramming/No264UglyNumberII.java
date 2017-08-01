package leetcode.sort.DynamicProgramming; /**
 * @author liucong
 * @ClassName: No264UglyNumberII
 * @Description:
 * @date 2016年10月25日 4:39 PM
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Hint:
 * <p>
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.Show More Hint
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Dynamic Programming leetcode.Heap leetcode.Math
 * Hide Similar Problems (H) Merge k Sorted Lists (E) Count Primes (E) Ugly Number (M) Perfect Squares (M) Super Ugly Number
 */
public class No264UglyNumberII {
    public No264UglyNumberII() {
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int nextUgly = 1;
        while (nextUgly < n) {
            int a = 0;
            int b = 0;
            int c = 0;
            for (Integer i : list) {
                if (2 * i > list.get(list.size() - 1)) {
                    a = 2 * i;
                    break;
                }
            }
            for (Integer i : list) {
                if (3 * i > list.get(list.size() - 1)) {
                    b = 3 * i;
                    break;
                }
            }
            for (Integer i : list) {
                if (5 * i > list.get(list.size() - 1)) {
                    c = 5 * i;
                    break;
                }
            }
            int d  = min(a,b,c);
            list.add(d);
            nextUgly++;
        }
        return list.get(list.size() - 1);
    }

    public int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {
        No264UglyNumberII un = new No264UglyNumberII();
        System.out.println(un.nthUglyNumber(4));
    }
}
