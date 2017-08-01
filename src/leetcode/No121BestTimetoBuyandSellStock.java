package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No121BestTimetoBuyandSellStock
 * @Description:
 * @date 2017年04月22日 下午3:10
 **/
public class No121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int[] dp = new  int[prices.length];
        int maxPro = 0;
        dp[0]=0;
        for(int i = 1;i<prices.length;i++){
            dp[i] = prices[i]-prices[i-1]+(dp[i-1]<0?0:dp[i-1]);
            maxPro = Math.max(maxPro,dp[i]);
        }
        return maxPro;
    }

    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public int maxProfit2(int[] prices) {
        int min =  Integer.MAX_VALUE;
        int maxPro = 0;
        for(int i = 0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            maxPro = Math.max(maxPro,prices[i]-min);
        }
        return maxPro;
    }
}
