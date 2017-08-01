package leetcode;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: leetcode.No232ImplementQueueusingStacks
 * @Description:
 * @date 2017年04月24日 下午3:58
 **/
public class No232ImplementQueueusingStacks {
    public class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> tmpStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack=new Stack<Integer>();
            tmpStack=new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
            }else{
                while(!stack.isEmpty()){
                    tmpStack.push(stack.pop());
                }
                stack.push(x);
                while(!tmpStack.isEmpty()){
                    stack.push(tmpStack.pop());
                }
            }

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
