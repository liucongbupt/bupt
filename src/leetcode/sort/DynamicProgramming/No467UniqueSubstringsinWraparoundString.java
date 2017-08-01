package leetcode.sort.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liucong
 * @ClassName: No467UniqueSubstringsinWraparoundString
 * @Description:
 * @date 2017年04月09日 下午9:35
 **/
public class No467UniqueSubstringsinWraparoundString {
    public static int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLenCur = 0;
        for (int i = 0; i <p.length() ; i++) {
            if (i>0&&(p.charAt(i)-p.charAt(i-1)==1||p.charAt(i-1)-p.charAt(i)==25)){
                maxLenCur++;
            }else {
                maxLenCur=1;
            }
            count[p.charAt(i)-'a']=Math.max(maxLenCur,count[p.charAt(i)-'a']);
        }
        int rtn = 0;
        for (int i = 0; i < 26 ; i++) {
            rtn+=count[i];
        }
        return rtn;
    }
    public static void main(String[] args) {
//        System.out.println(isSubString("za"));
//        System.out.println(isSubString("abc"));
//        System.out.println(isSubString("abd"));
        System.out.println(findSubstringInWraproundString("zaba"));
//        System.out.println(findSubstringInWraproundString("cac"));
//        System.out.println();
//        System.out.println();
    }
}
