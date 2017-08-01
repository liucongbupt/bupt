package leetcode.sort.DynamicProgramming;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No140WordBreakII
 * @Description:
 * @date 2017年04月07日 下午4:13
 **/
public class No140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }


    private final Map<String, List<String>> cache = new HashMap<>();

    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }

//    public List<String> wordBreak(String s, Set<String> dict) {
//        if (cache.containsKey(s)) return cache.get(s);
//        List<String> result = new LinkedList<>();
//        if (dict.contains(s)) result.add(s);
//        for (int i = 1; i < s.length(); i++) {
//            String left = s.substring(0,i), right = s.substring(i);
//            if (dict.contains(left) && containsSuffix(dict, right)) {
//                for (String ss : wordBreak(right, dict)) {
//                    result.add(left + " " + ss);
//                }
//            }
//        }
//        cache.put(s, result);
//        return result;
//    }
}
