package leetcode.sort.HashTable;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No451SortCharactersByFrequency
 * @Description:
 * @date 2017年03月30日 上午10:37
 **/
public class No451SortCharactersByFrequency {
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new TreeMap<>();
        for (char c:s.toCharArray()
             ) {
            map.put(c,map.getOrDefault(c,0)+1);
        }



        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                sb.append(list.get(i).getKey());
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));

    }
}
