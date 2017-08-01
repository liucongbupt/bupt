package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No10RegularExpressionMatching
 * @Description:
 * @date 2017年05月03日 下午5:04
 **/
public class No10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s==null||p==null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i = 1; i <= m; i++)
            f[i][0] = false;
        // p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty
        for (int j = 1; j <= n; j++)
            f[0][j] = j > 1 && '*' == p.charAt(j-1) && f[0][j - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (p.charAt(j-1) != '*')
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                else
                    // p[0] cannot be '*' so no need to check "j > 1" here
                    f[i][j] = f[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && f[i - 1][j];

        return f[m][n];
    }

    public static void main(String[] args) {
        No10RegularExpressionMatching test = new No10RegularExpressionMatching();

        System.out.println(test.isMatch("aa", "a"));
        System.out.println(test.isMatch("aa", "aa"));
        System.out.println(test.isMatch("aaa", "aa"));
        System.out.println(test.isMatch("aa", "a*"));
        System.out.println(test.isMatch("aa", ".*"));
        System.out.println(test.isMatch("ab", ".*"));
        System.out.println(test.isMatch("aab", "c*a*b"));
        System.out.println(test.isMatch("ab", ".*b"));
    }
}
