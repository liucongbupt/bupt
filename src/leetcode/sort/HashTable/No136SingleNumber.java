package leetcode.sort.HashTable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liucong
 * @ClassName: No136SingleNumber
 * @Description:
 * @date 2017年03月28日 下午8:56
 **/
public class No136SingleNumber {
    public int singleNumber(int[] nums) {
        int rtn = 0;
        Set<Integer> set = new HashSet<>();
        for (int i:nums
             ) {
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            rtn = it.next();
        }
        return rtn;
    }

}
