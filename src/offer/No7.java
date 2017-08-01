package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No7
 * @Description:
 * @date 2017年03月07日 下午4:35
 **/
public class No7 {
    public static class MQueue<T>{
        private  Stack<T> stack1=new Stack<>();
        private  Stack<T> stack2=new Stack<>();

        public MQueue() {
        }

        // 添加操作，成在队列尾部插入结点
        public void appendTail(T t){
            stack1.push(t);
        }


        // 删除操作，在队列头部删除结点
        public T deleteHead() {

            // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
            // 并且将弹出的数据压入弹出栈中
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
            }

            // 如果弹出栈中还没有数据就抛出异常
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }

            // 返回弹出栈的栈顶元素，对应的就是队首元素。
            return stack2.pop();
        }
    }
    public class QueuesToStack
    {
        LinkedList<Integer> queue1=new LinkedList<Integer>();
        LinkedList<Integer> queue2=new LinkedList<Integer>();
        public void push(int value)//入栈
        {
            queue1.addLast(value);

        }

        public int pop()//出栈     必须是非空的栈才能出栈啊
        {
            if(sSize()!=0)//栈不为空
            {
                //移动一个队的n-1个到另一个中
                if(!queue1.isEmpty())//q1 空
                {
                    putN_1ToAnthor();
                    return queue1.removeFirst();
                }
                else  //q2 空
                {
                    putN_1ToAnthor();
                    return queue2.removeFirst();
                }
            }
            else
            {
                System.out.println("栈已经为空啦，不能出栈");
                return -1;
            }

        }

        public int sSize()
        {
            return queue1.size()+queue2.size();
        }

        public void putN_1ToAnthor()//从非空中出队n-1个到另一个队列   因为队列总是一空一非空
        {
            if(!queue1.isEmpty())
            {
                while(queue1.size()>1)
                {
                    queue2.addLast(queue1.removeFirst());
                }
            }
            else if(!queue2.isEmpty())
            {
                while(queue2.size()>1)
                {
                    queue1.addLast(queue2.removeFirst());
                }
            }
        }

    }


    /**
     * @param <T>
     */

    public static class MStack<T>{
        private Queue<T> queue1 = new LinkedList<>();
        private Queue<T> queue2 = new LinkedList<>();

        public void push(T t){
            if(!queue1.isEmpty()){
                queue1.add(t);
            }else{
                queue2.add(t);
            }
        }

        public T pop(){
            if(!queue1.isEmpty()){
                while(queue1.size()>1){
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }else{
                while (queue2.size()>1){
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }
        }
    }

    public static void main(String[] args) {
        MStack<Integer> a = new MStack<>();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);
        for (int i = 0; i < 5; i++) {
            System.out.println(a.pop());
        }
    }
}
