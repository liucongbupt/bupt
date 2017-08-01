package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No309BestTimetoBuyandSellStockwithCooldown
 * @Description:
 * @date 2017年04月08日 上午10:29
 **/
public class No309BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0)
            return 0;
        int n = prices.length;
        int[] s0 = new int[n];//buy
        int[] s1 = new int[n];//sell
        int[] s2 = new int[n];//cooldown
        s0[0]=-prices[0];
        s1[0]=Integer.MIN_VALUE;
        s2[0]=0;
        for (int i = 1; i < n; i++) {
            s0[i]=Math.max(s0[i-1],s2[i-1]-prices[i]);
            s1[i]=s0[i-1]+prices[i];
            s2[i]=Math.max(s2[i-1],s1[i-1]);
        }
        int max = Math.max(s0[n-1],s1[n-1]);
        return Math.max(max,s2[n-1]);
    }

//    public int maxProfit(int[] prices) {
//        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
//        for (int price : prices) {
//            prev_buy = buy;
//            buy = Math.max(prev_sell - price, prev_buy);
//            prev_sell = sell;
//            sell = Math.max(prev_buy + price, prev_sell);
//        }
//        return sell;
//    }
}
