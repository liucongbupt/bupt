package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No441ArrangingCoins
 * @Description:
 * @date 2016年11月22日 下午4:58
 **/

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 Subscribe to see which companies asked this question

 Hide Tags Binary Search leetcode.Math

 */
public class No441ArrangingCoins {
    public No441ArrangingCoins() {
    }
    public int arrangeCoins(int n) {
       return (int)(Math.sqrt(2*(long)n+0.25)-0.5);
    }
    public static void main(String[] args) {
        No441ArrangingCoins ac = new No441ArrangingCoins();
        System.out.println(ac.arrangeCoins(1804289383));
        System.out.println((int)Math.abs((Math.sqrt(1804289383*8+1)-1)/2));
    }
}
