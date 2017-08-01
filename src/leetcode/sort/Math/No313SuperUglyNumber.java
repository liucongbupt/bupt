package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No313SuperUglyNumber
 * @Description:
 * @date 2016年10月25日 5:10 PM
 **/

/**
 * Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math leetcode.Heap
 Hide Similar Problems (M) Ugly Number II

 */
public class No313SuperUglyNumber {

    public No313SuperUglyNumber() {

    }

    public static int nthSuperUglyNumberI(int n, int[] primes) {

        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < idx.length; j++) {
                ugly[i] = Math.min(ugly[i],primes[j]*ugly[idx[j]]);
            }
            for (int j = 0; j < idx.length; j++) {
                while(primes[j]*ugly[idx[j]]<=ugly[i]) idx[j]++;
            }
        }
        return ugly[n-1];
    }


    public static void main(String[] args) {
        No313SuperUglyNumber sun = new No313SuperUglyNumber();
        System.out.println(sun.nthSuperUglyNumberI(8,new int[]{2,3,5}));
    }
}
