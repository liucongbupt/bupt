package leetcode.sort.HashTable;

import java.util.*;

/**
 * @author liucong
 * @ClassName: No500KeyboardRow
 * @Description:
 * @date 2017年03月27日 下午2:37
 **/
public class No500KeyboardRow {

    public String[] findWords(String[] words) {
        String[] alp = new String[]{
                "QWERTYUIOPqwertyuiop",
                "ASDFGHJKLasdfghjkl",
                "ZXCVBNMzxcvbnm"
        };
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < alp.length; i++) {
            for (int j = 0; j < alp[i].length(); j++) {
                map.put(alp[i].charAt(j),i);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            int rol = map.get(temp.charAt(0));
            boolean add = true;
            for (int j = 1; j < temp.length(); j++) {
                if(rol!=map.get(temp.charAt(j)))
                    add=false;
            }
            if (add)
            list.add(new String(temp));
        }
//        return (leetcode.String[]) list.toArray();
            return  (String[])list.toArray(new String[list.size()]);
    }
}
