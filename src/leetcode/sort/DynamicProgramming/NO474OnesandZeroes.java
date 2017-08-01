package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: NO474OnesandZeroes
 * @Description:
 * @date 2017年04月08日 下午2:57
 **/
public class NO474OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s:strs
             ) {
            int[] count = count(s);
            for (int i = m; i >=count[0] ; i--) {
                for (int j = n; j >=count[1] ; j--) {
                    dp[i][j]=Math.max(dp[i-count[0]][j-count[1]],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    int[] count(String str){
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'0']++;
        }
        return count;
    }
}
