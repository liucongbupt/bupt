package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No96UniqueBinarySearchTrees
 * @Description:
 * @date 2017年04月06日 上午9:44
 **/
public class No96UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        if(n==0)
            return 0;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }
}
