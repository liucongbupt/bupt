package leetcode.sort.HashTable;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No49GroupAnagrams
 * @Description:
 * @date 2016年10月05日 4:00 PM
 **/

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class No49GroupAnagrams {
    public No49GroupAnagrams() {
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rtn = new ArrayList<List<String>>();
        if(strs==null) return rtn;
        Map<String,Integer> map = new HashMap<String,Integer>();
        int m = 0;
        for (int i = 0; i < strs.length; i++) {
            if(i==0){
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                rtn.add(list);
                char[] compareArray = strs[i].toCharArray();
                Arrays.sort(compareArray);
                String compare = String.valueOf(compareArray);
                map.put(compare,m);
            }else {
                char[] ca = strs[i].toCharArray();
                Arrays.sort(ca);
                String cop = String.valueOf(ca);
                if (map.containsKey(cop)) {
                    rtn.get(map.get(cop)).add(strs[i]);
                } else {
                    m++;
                    map.put(cop, m);
                    List<String> list = new ArrayList<String>();
                    list.add(strs[i]);
                    rtn.add(list);
                }
            }
        }

        return rtn;
    }
    public static void main(String[] args) {
        No49GroupAnagrams ga = new No49GroupAnagrams();
        List<List<String>> rtn = ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List a: rtn) {
            System.out.println(a);
        }
    }
}
