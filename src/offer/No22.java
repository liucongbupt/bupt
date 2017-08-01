package offer;

import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No22
 * @Description:
 * @date 2017年04月01日 上午11:15
 **/
public class No22 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
     * 【按书本上的思路进行求解，两者相差不大】
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return true：出栈序列是入栈序列的一个弹出顺序
     */
    public static boolean isPopOrder2(int[] push, int[] pop) {

        // 用于记录判断出栈顺序是不是入栈顺的一个出栈序列，默认false
        boolean isPossible = false;

        // 当入栈和出栈数组者都不为空，并且都有数据，并且数据个数都相等
        if (push != null && pop != null && push.length > 0 && push.length == pop.length) {
            // 用于存放入栈时的数据
            Stack<Integer> stack = new Stack<>();
            // 记录下一个要处理的入栈元素的位置
            int nextPush = 0;
            // 记录下一个要处理的出栈元素的位置
            int nextPop = 0;
            // 如果出栈元素没有处理完就继续进行处理
            while (nextPop < pop.length) {
                // 如果栈为空或者栈顶的元素与当前处理的出栈元素不相同，一直进行操作
                while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                    // 如果入栈的元素已经全部入栈了，就退出内层循环
                    if (nextPush >= push.length) {
                        break;
                    }

                    // 执行到此处说明还有入栈元素可以入栈
                    // 即将元素入栈
                    stack.push(push[nextPush]);
                    // 指向下一个要处理的入栈元素的位置
                    nextPush++;
                }

                // 执行到此处有两种情况：
                // 第一种：在栈顶上找到了一个与入栈元素相等的元素
                // 第二种：在栈顶上没有找到一个与入栈元素相等的元素，而且输入栈的元素已经全部入栈了

                // 对于第二种情况就说弹出栈的顺序是不符合要求的，退出外层循环
                if (stack.peek() != pop[nextPop]) {
                    break;
                }

                // 对应到第一种情况：需要要栈的栈顶元素弹出
                stack.pop();
                // 指向下一个要处理的出栈元素的位置
                nextPop++;
            }

            // 执行到此处有两种情况
            // 第一种：外层while循环的在第一种情况下退出，
            // 第二种：所有的出栈元素都被正确匹配

            // 对于出现的第一种情况其stack.isEmpty()必不为空，原因为分析如下：
            // 所有的入栈元素一定会入栈，但是只有匹配的情况下才会出栈，
            // 匹配的次数最多与入栈元素个数元素相同（两个数组的长度相等），如果有不匹配的元素，
            // 必然会使出栈的次数比入栈的次数少，这样栈中至少会有一个元素
            // 对于第二种情况其stack.isEmpty()一定为空
            // 所以书本上的nextPop == pop.length（pNextPop-pPop==nLength）是多余的
            if (stack.isEmpty()) {
                isPossible = true;
            }
        }

        return isPossible;
    }
}
