package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No72EditDistance
 * @Description:
 * @date 2017年04月23日 下午8:39
 **/
public class No72EditDistance {
    int[][] dp;
    int solve(int x, int y, String w1, String w2) {
        if (x>=w1.length()){
            if(y>=w2.length())return 0;
            else return w2.length()-y;
        }

        if (y>=w2.length()){
            if(x>=w1.length())return 0;
            else return w1.length()-x;
        }

        if (dp[x][y]>0)
            return dp[x][y];
        if (w1.charAt(x)==w2.charAt(y))
            dp[x][y]=solve(x+1,y+1,w1,w2);
        else
            dp[x][y] = min(solve(x + 1, y, w1, w2)+1,
                    solve(x, y + 1, w1, w2)+1,
                    solve(x + 1, y + 1, w1, w2)+1
            );
        return dp[x][y];


    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        return solve(0, 0, word1, word2);
    }

    int min(int a, int b, int c) {
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        No72EditDistance test = new No72EditDistance();
        test.minDistance("a","ab");
        test.minDistance1("a","ab");
    }
}
