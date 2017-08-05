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
        HashMap<Character,Integer> map = new HashMap<>();
        int start = -1;
        int max = 0;
        for(int end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end)))
                start = Math.max(start,map.get(s.charAt(end)));
            map.put(s.charAt(end),end);
            max = Math.max(max,end-start);
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int start = -1;
        int max = 0;
        for(int end=0;end<s.length();end++){
            if(map[s.charAt(end)]!=-1)
                start = Math.max(start,map[s.charAt(end)]);
            map[s.charAt(end)] = end;
            max = Math.max(max,end-start);
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
