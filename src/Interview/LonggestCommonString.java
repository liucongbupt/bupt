package Interview;

import java.util.Map;

/**
 * @author liucong
 * @ClassName: LonggestCommonString
 * @Description:
 * @date 2017年04月21日 上午11:20
 **/
public class LonggestCommonString {
    int[][] dp;
    int max(int a,int b,int c){
        int tmp = Math.max(a,b);
        return Math.max(tmp,c);
    }

    int LCS3(String x,String y){
        dp = new int[x.length()+1][y.length()+1];
        int max = -1;

        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if (x.charAt(i-1)==y.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
    int LCS4(String x,String y){
        dp = new int[x.length()+1][y.length()+1];
        int max = -1;

        for (int i = x.length()-1; i >=0 ; i--) {
            for (int j = y.length()-1; j >=0 ; j--) {
                if (x.charAt(i)==y.charAt(j))
                    dp[i][j]=dp[i+1][j+1]+1;
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LonggestCommonString test = new LonggestCommonString();
//        System.out.println(test.LCS1("abcd","abd"));
        System.out.println(test.LCS3("abcdefg","abcd"));
        System.out.println(test.LCS4("abcdefg","abcd"));
    }
}
