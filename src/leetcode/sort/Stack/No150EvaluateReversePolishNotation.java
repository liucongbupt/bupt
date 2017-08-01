package leetcode.sort.Stack;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No150EvaluateReversePolishNotation
 * @Description:
 * @date 2017年04月11日 下午9:50
 **/
public class No150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens
                ) {
            if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int i = stack.pop();
                int j = stack.pop();
                switch (s){
                    case "+":
                        stack.push(j+i);
                        break;
                    case "-":
                        stack.push(j-i);
                        break;
                    case "*":
                        stack.push(j*i);
                        break;
                    case "/":
                        stack.push(j/i);
                        break;
                }
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
