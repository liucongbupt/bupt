package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liucong
 * @ClassName: leetcode.No3LongestSubstringWithoutRepeatingCharacters
 * @Description:
 * @date 2017年04月23日 下午4:48
 **/
public class No3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int  max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                start = Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        int start = 0;
        int[] dp = new int[256];
        Arrays.fill(dp,-1);
        for(int i = 0;i<s.length();i++){
            char t = s.charAt(i);
            if(dp[t]!=-1)
                start = Math.max(start,dp[t]+1);
            dp[s.charAt(i)]=i;
            max = Math.max(max,i-start+1);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("aaaa"));
    }
}
