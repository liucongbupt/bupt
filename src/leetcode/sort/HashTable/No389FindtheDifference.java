package leetcode.sort.HashTable;

import java.util.HashMap;

/**
 * @author liucong
 * @ClassName: No389FindtheDifference
 * @Description:
 * @date 2017年03月27日 下午5:49
 **/
public class No389FindtheDifference {
    public char findTheDifference(String s, String t) {
        char rtn = 0;
        HashMap<Character,Integer> map =new HashMap<>();
        for (char c:s.toCharArray()
             ) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:t.toCharArray()
             ) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if (map.get(c)==0)
                map.remove(c);
            }else {
                rtn = c;
            }
        }
        return rtn;
    }

}
