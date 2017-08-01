package leetcode.sort.Stack;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No402RemoveKDigits
 * @Description:
 * @date 2017年04月12日 上午11:38
 **/
public class No402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k==len)
            return "0";

        Stack<Character> s = new Stack<>();

        int i = 0;
        while (i<len){
            while (k>0&&!s.isEmpty()&&num.charAt(i)<s.peek()){
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
            i++;
        }

        while (k>0){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        while (sb.length()>1&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
