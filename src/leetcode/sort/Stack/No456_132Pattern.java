package leetcode.sort.Stack;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No456_132Pattern
 * @Description:
 * @date 2017年04月12日 上午10:47
 **/
public class No456_132Pattern {
    class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        if (nums==null||nums.length<3)
            return false;
        Stack<Pair> stack = new Stack<>();
        for (int n:nums
             ) {
            if(stack.isEmpty()||n<stack.peek().min) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }

            }
        }
        return false;
    }
}
