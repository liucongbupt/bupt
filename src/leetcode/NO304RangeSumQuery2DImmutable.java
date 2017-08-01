package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.NO304RangeSumQuery2DImmutable
 * @Description:
 * @date 2017年04月22日 下午4:39
 **/
public class NO304RangeSumQuery2DImmutable {
    public class NumMatrix {
        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix==null||matrix.length==0||matrix[0].length==0){
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <=n ; j++) {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int rowMin = Math.min(row1,row2);
            int rowMax = Math.max(row1,row2);
            int colMin = Math.min(col1,col2);
            int colMax = Math.max(col1,col2);
            return dp[rowMax+1][colMax+1]-dp[rowMax+1][colMin]-dp[rowMin][colMax+1]+dp[rowMin][colMin];
        }
    }
}
