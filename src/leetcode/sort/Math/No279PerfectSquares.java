package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No279PerfectSquares
 * @Description:
 * @date 2016年11月14日 上午10:52
 **/

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 Credits:while (n % 4 == 0) n /= 4;
 if (n % 8 == 7) return 4;
 for (int a = 0; a * a <= n; ++a) {
 int b = sqrt(n - a * a);
 if (a * a + b * b == n) {
 return !!a + !!b;
 }
 }
 return 3;
 Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags Dynamic Programming Breadth-first Search leetcode.Math
 Hide Similar Problems (E) Count Primes (M) Ugly Number II

 */
public class No279PerfectSquares {
    public No279PerfectSquares() {
    }

    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a <= n; ++a) {
            int b = (int)Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                if(a*b==0) return 1;
                if(a*b!=0) return 2;
            }
        }
        return 3;
    }
    public static void main(String[] args) {
        No279PerfectSquares aa = new No279PerfectSquares();
        System.out.println(aa.numSquares(6));
    }
}
