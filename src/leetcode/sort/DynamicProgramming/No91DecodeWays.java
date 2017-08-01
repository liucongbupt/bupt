package leetcode.sort.DynamicProgramming;

/**
 * @author liucong
 * @ClassName: No91DecodeWays
 * @Description:
 * @date 2017年04月06日 上午9:44
 **/
public class No91DecodeWays {
    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!='0'?1:0;
        for(int i = 2;i<= n;i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int sec = Integer.valueOf(s.substring(i-2,i));
            if(first>0&&first<10){
                dp[i]+=dp[i-1];
            }
            if(sec>9&&sec<27){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
