package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No380InsertDeleteGetRandomx
 * @Description:
 * @date 2017年03月01日 下午8:24
 **/

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the
 */
public class No380InsertDeleteGetRandomx {

    public class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }

            int idx = map.remove(val);
            int last = list.remove(list.size() - 1);
            if(val != last) {
                list.set(idx, last);
                map.put(last, idx);
            }
            return true;
        }

        public int getRandom() {
            return list.get(rnd.nextInt(list.size()));
        }
    }
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
