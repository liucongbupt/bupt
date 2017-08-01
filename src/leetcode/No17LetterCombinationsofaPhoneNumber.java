package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: leetcode.No17LetterCombinationsofaPhoneNumber
 * @Description:
 * @date 2017年04月26日 下午2:32
 **/
public class No17LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null||digits.length()==0)
            return list;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(list, new StringBuilder(), map, digits, 0);
        return list;
    }

    static void backtrack(List<String> list, StringBuilder sb, String[] map, String digits, int idx) {
        if (idx == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = map[digits.charAt(idx) - '0'];
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            backtrack(list, sb, map, digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
