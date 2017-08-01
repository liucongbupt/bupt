package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucong on 9/26/16.
 */
public class No17LetterCombinationsofaPhoneNumber {
    public No17LetterCombinationsofaPhoneNumber() {
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits=="") return result;
        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        char[] temp = new char[digits.length()];
        dfs(0,temp,result,digits,map);
        return result;
    }

    public void dfs(int index,char[] midChar,List<String> result,String digits,String[] map){
        if(index==digits.length()){
            result.add(new String(midChar));
            return;
        }
        char temp = digits.charAt(index);
        for (int i = 0; i < map[temp-'0'].length(); i++) {
            midChar[index]=map[temp-'0'].charAt(i);
            dfs(index+1,midChar,result,digits,map);
        }

    }
    public static void main(String[] args) {
    }
}
