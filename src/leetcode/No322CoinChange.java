package leetcode;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: leetcode.No322CoinChange
 * @Description:
 * @date 2017年04月20日 下午9:34
 **/
public class No322CoinChange {
    public static int coinChange3(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j]&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];

    }

    public int solve(int amount,int[] coins,int[] dp){
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(dp[amount-1]!=0){
            return dp[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = solve(amount-coins[i],coins,dp);
            if (res>=0&&res<min)
                min=res+1;
        }
        dp[amount-1] = (min==Integer.MAX_VALUE)?-1:min;
        return dp[amount-1];
    }
    public int coinChange4(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount];
        return  solve(amount,coins,dp);
    }
    public static void main(String[] args) {
        coinChange3(new int[]{2},3);
    }
}
