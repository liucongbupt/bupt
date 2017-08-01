package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No322CoinChange
 * @Description:
 * @date 2017年04月08日 上午11:28
 **/
public class No322CoinChange {
    int MAX_VALUE = Integer.MAX_VALUE-100;
    public int search(int idx,int[] coins,int amount,int[] dp){
        if (idx>=coins.length)
            return MAX_VALUE;
        if (amount==0)
            return 0;
        if (amount<0)
            return MAX_VALUE;

        if (dp[idx]!=MAX_VALUE)
            return dp[idx];

        int a = search(idx,coins,amount-coins[idx],dp);
        int b = search(idx+1,coins,amount,dp);
        dp[idx] = Math.min(a+1,b);
        return dp[idx];
    }
    public static int coinChange(int[] coins, int amount) {
        if (coins==null||coins.length==0){
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0]=0;
        for (int i = 1; i <= amount ; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i){
                    int sum = dp[i-coins[j]];
                    if (sum!=Integer.MAX_VALUE&&sum+1<dp[i])
                        dp[i]=sum+1;
                }
            }
        }
        if (dp[amount]==Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0)
//            return -1;
//
//        if (amount <= 0)
//            return 0;
//
//        int dp[] = new int[amount + 1];
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for (int am = 1; am < dp.length; am++) {
//            for (int i = 0; i < coins.length; i++) {
//                if (coins[i] <= am) {
//                    int sub = dp[am - coins[i]];
//                    if (sub != Integer.MAX_VALUE && sub + 1 < dp[am])
//                        dp[am] = sub + 1;
//                }
//            }
//        }
//        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
//    }

    public static void main(String[] args) {
        int[] test = new int[]{156,265,40,280};
        System.out.println(coinChange(test, 9109));

    }
}
