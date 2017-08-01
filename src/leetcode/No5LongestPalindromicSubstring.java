package leetcode;

/**
 * @author liucong
 * @ClassName: leetcode.No5LongestPalindromicSubstring
 * @Description:
 * @date 2017年04月23日 下午9:37
 **/
public class No5LongestPalindromicSubstring {


    public static String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        int i, j;

        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < s.length(); j++) {
                if (i >= j)
                    dp[i][j] = true; //当i == j 的时候，只有一个字符的字符串; 当 i > j 认为是空串，也是回文
                else
                    dp[i][j] = false; //其他情况都初始化成不是回文
            }
        }
        int rl = 0;
        int rr = 0;
        int max = -1;
        for (int k = 1; k < s.length(); k++) {
            for (int l = 0; l < k; l++) {
                if (s.charAt(k) == s.charAt(l)) {
                    dp[l][k] = dp[l + 1][k - 1];
                    if (dp[l][k]) {
                        int tmp = k - l + 1;
                        if (tmp > max) {
                            rl = l;
                            rr = k;
                            max = tmp;
                        }
                    }
                } else {
                    dp[k][l] = false;
                }
            }
        }
        return s.substring(rl, rr + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }
}
