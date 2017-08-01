package leetcode.sort.String;

import edu.princeton.cs.algs4.Stack;

/**
 * @author liucong
 * @ClassName: No383RansomNote
 * @Description:
 * @date 2017年04月11日 下午9:00
 **/
public class No383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }

}
