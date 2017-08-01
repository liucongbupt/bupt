package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No122BestTimeToSellStock
 * @Description:
 * @date 2017年02月26日 下午8:04
 **/

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Subscribe to see which companies asked this question.
 */
public class No122BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        int rtn = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if((prices[i+1]-prices[i])>0){
                rtn+=(prices[i+1]-prices[i]);
            }
        }
        return rtn;
    }
}
