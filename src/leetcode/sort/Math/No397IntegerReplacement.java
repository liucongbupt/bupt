package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No397IntegerReplacement
 * @Description:
 * @date 2016年11月22日 上午10:46
 **/

/**
 * Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.
 What is the minimum number of replacements needed for n to become 1?

 Example 1:

 Input:
 8

 Output:
 3

 Explanation:
 8 -> 4 -> 2 -> 1
 Example 2:

 Input:
 7

 Output:
 4

 Explanation:
 7 -> 8 -> 4 -> 2 -> 1
 or
 7 -> 6 -> 3 -> 2 -> 1
 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math Bit Manipulation

 */
public class No397IntegerReplacement {
    public No397IntegerReplacement() {

    }


    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        else {
            long t = n;
            return 2 + Math.min(integerReplacement((int)((t+1)/2)), integerReplacement((int)((t - 1) / 2)));
        }

    }
    public static void main(String[] args) {
        No397IntegerReplacement ir = new No397IntegerReplacement();
        System.out.println(ir.integerReplacement(10000));
    }
}
