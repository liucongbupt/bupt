package leetcode;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: leetcode.No155MinStack
 * @Description:
 * @date 2017年04月24日 下午4:46
 **/
public class No155MinStack {
    public class MinStack {
        Stack<Integer> stack;
        Stack<Integer> mstack;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            mstack=new Stack<>();
        }

        public void push(int x) {
            if(mstack.isEmpty()){
                mstack.push(x);
            }else{
                if(x<mstack.peek()){
                    mstack.push(x);
                }else{
                    mstack.push(mstack.peek());
                }
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            mstack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return mstack.peek();
        }
    }
}
