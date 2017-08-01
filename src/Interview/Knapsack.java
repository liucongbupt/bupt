package Interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: Knapsack
 * @Description:01背包问题和完全背包问题
 *  小偷有一个容量为W的背包，有n件物品，第i个物品价值vi，且重wi
 *  目标:找到xi使得对于所有的xi={0,1}
 *  sum(wi*xi)<=W,并且sum(xi*vi)最大
 * @date 2017年04月20日 下午8:10
 **/
public class Knapsack {
    int N = 3;
    int W = 2;
    int[] w = {1,1,1};
    int[] v = {10,20,30};
    int[] y={0,0,0};
    int[][] dp ;

    int solve(int N, int weight)
    {
        if(N==0||weight==0)
            return 0;

        if (dp[N][weight]>=0)
            return dp[N][weight];

        if (w[N-1]>weight) {
            y[N - 1] = 0;
            dp[N][weight] = solve(N - 1, weight);
        }else{
            int tmp1 = solve(N-1,weight-w[N-1])+v[N-1];
            int tmp2 = solve(N-1,weight);
            if (tmp1>tmp2) y[N-1]=1;
            else y[N-1]=0;
            dp[N][weight] = Math.max(tmp1,tmp2);
        }
            dp[N][weight] = Math.max(solve(N-1,weight-w[N-1])+v[N-1],
                    solve(N-1,weight));
        return dp[N][weight];
    }

    int Knapsack1(){
        dp = new int[N+1][W+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i*j!=0)
                    dp[i][j]=-1;
            }
        }
        return solve(N,W);
    }

    int Knapsack2(){
        dp = new int[N+1][W+1];
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= W; j++) {
                if (j<w[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.max(dp[i-1][j-w[i-1]]+v[i-1],dp[i-1][j]);
            }
        }
        return dp[N][W];
    }

    int Knapsack3(){
        dp = new int[2][W+1];
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= W; j++) {
                if (j<w[i-1])
                    dp[i%2][j]=dp[(i-1)%2][j];
                else
                    dp[i%2][j]=Math.max(dp[(i-1)%2][j-w[i-1]]+v[i-1],dp[(i-1)%2][j]);
            }
        }
        return dp[N%2][W];
    }

    //无须装满
    int Knapsack4(){

        int[] dp = new int[W+1];
        for (int i = 0; i <N ; i++) {
            for (int j = W; j >=w[i]; j--) {
                dp[i]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[W];
    }

    //须装满
    int Knapsack5(){
        int[] dp = new int[W+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;

        for (int i =0; i <N ; i++) {
            for (int j = W; j >=w[i]; j--) {
                dp[i]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[W];
    }

    //完全背包
    int Knapsack6(){
        int[] dp = new int[W+1];
        for (int i = 0; i <N ; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[W];
    }
    void print(int[] y){
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Knapsack test = new Knapsack();
        System.out.println(test.Knapsack1());
//        test.print(test.y);
        System.out.println(test.Knapsack2());
        System.out.println(test.Knapsack3());
        System.out.println(test.Knapsack4());
        System.out.println(test.Knapsack5());
        System.out.println(test.Knapsack6());
    }

}
