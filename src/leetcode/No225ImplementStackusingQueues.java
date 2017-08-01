package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: leetcode.No225ImplementStackusingQueues
 * @Description:
 * @date 2017年04月24日 下午3:51
 **/
public class No225ImplementStackusingQueues {

    public class MyStack {
        Queue<Integer> queue;
        Queue<Integer> queueTemp;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
            queueTemp = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(queue.isEmpty()){
                queue.add(x);
            }else{
                while (!queue.isEmpty()){
                    queueTemp.offer(queue.poll());
                }
                queue.offer(x);
                while (!queueTemp.isEmpty()){
                    queue.offer(queueTemp.poll());
                }
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
           return queue.element();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
