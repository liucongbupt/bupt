package leetcode.sort.DynamicProgramming;

import java.util.List;

/**
 * @author liucong
 * @ClassName: No139WordBreak
 * @Description:
 * @date 2017年04月07日 下午3:53
 **/
public class No139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()<1||wordDict.size()<1){
            return false;
        }
        boolean[] match = new boolean[s.length()+1];
        match[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (match[j]&&wordDict.contains(s.substring(j,i)))
                    match[i]=true;
            }
        }
        return match[s.length()];
    }

}
