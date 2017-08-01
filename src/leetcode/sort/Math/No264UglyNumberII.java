package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: No264UglyNumberII
 * @Description:
 * @date 2016年10月25日 4:39 PM
 **/

import java.util.ArrayList;
import java.util.LinkedList;
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

    public int nthUglyNumberEx(int n) {
        int u = 0;
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        List<Integer> l3 = new LinkedList<Integer>();
        l1.add(1);
        l2.add(1);
        l3.add(1);

        for(int i=0; i<n; i++) {
            u = Math.min( Math.min(l1.get(0), l2.get(0)), l3.get(0));

            if(l1.get(0) == u) l1.remove(0);
            if(l2.get(0) == u) l2.remove(0);
            if(l3.get(0) == u) l3.remove(0);

            l1.add(u*2);
            l2.add(u*3);
            l3.add(u*5);
        }
        return u;
    }


    public int nthUglyNumberExx(int n) {
        int[] ugly = new int[n];
        int[] prime = new int[]{2,3,5};
        int[] idx = new int[3];
        ugly[0]=1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < prime.length; j++) {
                ugly[i] = Math.min(ugly[i],prime[j]*ugly[idx[j]]);
            }
            for (int j = 0; j < prime.length; j++) {
                if(prime[j]*ugly[idx[j]]<=ugly[i]) idx[j]++;
            }
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        No264UglyNumberII un = new No264UglyNumberII();
        System.out.println(un.nthUglyNumberEx(4));
    }
}
