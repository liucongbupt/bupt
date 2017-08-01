package Interview;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: LonggestCommonSubsequence
 * @Description:
 * @date 2017年04月21日 上午9:11
 **/
public class LonggestCommonSubsequence {
    int[][] dp;
    int max(int a,int b,int c){
        int tmp = Math.max(a,b);
        return Math.max(tmp,c);
    }
    int search (int xi,int yi,String x,String y){
        if (xi>=x.length()||yi>=y.length())
            return 0;

        if (dp[xi][yi]>0)
            return dp[xi][yi];

        int a = -1;
        if (x.charAt(xi)==y.charAt(yi))
            a = search(xi+1,yi+1,x,y)+1;
        int b=search(xi,yi+1,x,y);
        int c=search(xi+1,yi,x,y);

        dp[xi][yi] = max(a,b,c);
        return dp[xi][yi];
    }

    int search2 (int xi,int yi,String x,String y){
        if (xi<0||yi<0)
            return 0;

        if (dp[xi][yi]>0)
            return dp[xi][yi];

        int a = -1;
        if (x.charAt(xi)==y.charAt(yi))
            a  = search2(xi-1,yi-1,x,y)+1;
        int b = search2(xi,yi-1,x,y);
        int c = search2(xi-1,yi,x,y);

        dp[xi][yi]=max(a,b,c);
        return dp[xi][yi];
    }

    public int  LonggestCommonSubsequence1(String x,String y){

        dp = new int[x.length()][y.length()];
        return search(0,0,x,y);
    }

    public int  LonggestCommonSubsequence2(String x,String y){

        dp = new int[x.length()][y.length()];
        return search2(x.length()-1,y.length()-1,x,y);
    }

    public int  LonggestCommonSubsequence3(String x,String y){

        dp = new int[x.length()+1][y.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[x.length()][y.length()];
    }
    public int  LonggestCommonSubsequence4(String x,String y){

        dp = new int[x.length()+1][y.length()+1];

        for (int i = x.length()-1; i >=0 ; i--) {
            for (int j = y.length()-1; j >=0 ; j--) {
                if (x.charAt(i)==y.charAt(j))
                    dp[i][j]=dp[i+1][j+1]+1;
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        LonggestCommonSubsequence test = new LonggestCommonSubsequence();
        System.out.println(test.LonggestCommonSubsequence1("1234789","1024789"));
        System.out.println(test.LonggestCommonSubsequence2("1234789","1024789"));
        System.out.println(test.LonggestCommonSubsequence3("1234789","1024789"));
        System.out.println(test.LonggestCommonSubsequence4("1234789","1024789"));
    }
}
