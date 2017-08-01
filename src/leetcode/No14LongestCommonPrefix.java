package leetcode;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: leetcode.No14LongestCommonPrefix
 * @Description:
 * @date 2017年04月26日 上午10:52
 **/
public class No14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs!=null&&strs.length!=0){
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length-1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (a[i]==b[i]){
                    sb.append(a[i]);
                }else {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0) return "";
        String min = strs[0];

        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length()<min.length()) min = strs[i];
        }

        int i = 0;
        int pos = 0;

        for (; i < min.length(); i++) {

            for(int j =0;j< strs.length;j++){
                if(min.charAt(i)!=strs[j].charAt(i)) {
                    pos = 1;
                    break;
                }
            }
            if(pos==1) break;
        }

        return min.substring(0,i);
    }
    public static void main(String[] args) {
        String a = "aab";
        String b = "aabccccc";
        System.out.println();
    }
}
