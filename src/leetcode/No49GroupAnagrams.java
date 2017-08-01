package leetcode;

import java.util.*;

/**
 * @author liucong
 * @ClassName: leetcode.No49GroupAnagrams
 * @Description:
 * @date 2017年04月27日 下午10:55
 **/
public class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rtn = new LinkedList<>();
        if(strs==null||strs.length==0)
            return rtn;
        Map<String,List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for(int i = 0;i<strs.length;i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String s = String.valueOf(tmp);
            if (!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }

        for(String s:map.keySet()){
            rtn.add(map.get(s));
        }
        return rtn;
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
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
}
