package leetcode.sort.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucong on 9/26/16.
 */

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class No22GenerateParentheses {

    public No22GenerateParentheses() {
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<=0) return result;
        String str  = new String();
        dfs(result,str,n,n);
        return result;
    }
    public void dfs(List<String> res, String item, int left, int right){
        if(left>right)
            return;
        if(left==0&&right==0){
            res.add(item);
            return;
        }
        if(left>0)
            dfs(res,item+'(',left-1,right);
        if(right>0)
            dfs(res,item+')',left,right-1);
    }

    public static void main(String[] args) {
        No22GenerateParentheses a = new No22GenerateParentheses();
        List<String> b = a.generateParenthesis(3);
        for (String c:b) {
            System.out.println(c);
        }
    }
}
