package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No343IntegerBreak
 * @Description:
 * @date 2016年11月15日 下午4:07
 **/

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Hint:

 There is a simple O(n) solution to this problem.
 You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags Dynamic Programming leetcode.Math

 */
public class No343IntegerBreak {
    public No343IntegerBreak() {
    }
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int rtn =1;

        while(n>4){
            rtn *= 3;
            n -= 3;
        }
        return n*rtn;
    }
    public static void main(String[] args) {

    }
}
