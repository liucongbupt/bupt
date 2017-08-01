package leetcode.sort.HashTable;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No347TopKFrequenElements
 * @Description:
 * @date 2017年03月28日 下午10:05
 **/
public class No347TopKFrequenElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        List<Integer> rtn = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max= Math.max(max,map.get(nums[i]));
        }


        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        for (int i = 0; i < k; i++) {
            rtn.add(list.get(i).getKey());
        }
        return rtn;
    }
}
