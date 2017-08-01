package leetcode.sort.HashTable;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liucong
 * @ClassName: No187RepeatedDNASequences
 * @Description:
 * @date 2017年03月03日 下午4:21
 **/
public class No187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(),repeated = new HashSet<>();
        for (int i = 0; i+9 < s.length(); i++) {
            String str= s.substring(i,i+10);
            if(seen.contains(str)){
                repeated.add(str);
            }
            seen.add(str);
        }
        return new ArrayList<>(repeated);
    }
}
