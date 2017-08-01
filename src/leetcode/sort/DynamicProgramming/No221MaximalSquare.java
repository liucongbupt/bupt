package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No221MaximalSquare
 * @Description:
 * @date 2017年04月07日 下午5:14
 **/
public class No221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i]=='1')
                dp[0][i]=1;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]=='1')
                dp[i][0]=1;
        }
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else if (matrix[i][j]=='1'){
                    dp[i][j]=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
    int min(int a,int b,int c){
        int temp = Math.min(a,b);
        return Math.min(temp,c);
    }
}
