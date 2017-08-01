package offer;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No21
 * @Description:
 * @date 2017年03月31日 下午11:01
 **/
public class No21 {

    public static class StackWithMin<T extends Comparable<T>> {
        private Stack<T> stack;
        private Stack<T> min;

        public StackWithMin() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public T pop() {

            min.pop();
            return stack.pop();

        }

        public void push(T t) {
            if (min.isEmpty()||t.compareTo(min.peek())<0)
                min.push(t);
            else min.push(min.peek());
            stack.push(t);
        }

        public T min() {
            if (min.isEmpty())
                throw new RuntimeException("Min is null");
            return min.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() );
        stack.push(4);
        System.out.println(stack.min() );
        stack.push(2);
        System.out.println(stack.min() );
        stack.push(3);
        System.out.println(stack.min() );
        stack.pop();
        System.out.println(stack.min() );
        stack.pop();
        System.out.println(stack.min() );
        stack.push(0);
        System.out.println(stack.min() );
    }

}
