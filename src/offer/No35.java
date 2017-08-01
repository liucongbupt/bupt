package offer;

import java.util.HashMap;

/**
 * @author liucong
 * @ClassName: No35
 * @Description:
 * @date 2017年04月02日 下午10:50
 **/
public class No35 {
   static char firstNotRepeatingChar(char[] chars){
        HashMap<Character,Integer> map = new HashMap<>();
        char rtn = '0';
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i])==1){
                rtn=chars[i];
                break;
            }
        }
        return rtn;
    }

        public static void main(String[] args) {
            System.out.println(firstNotRepeatingChar("google".toCharArray())); // l
            System.out.println(firstNotRepeatingChar("aabccdbd".toCharArray())); // '\0'
            System.out.println(firstNotRepeatingChar("abcdefg".toCharArray())); // a
            System.out.println(firstNotRepeatingChar("gfedcba".toCharArray())); // g
            System.out.println(firstNotRepeatingChar("zgfedcba".toCharArray())); // g
        }
}
