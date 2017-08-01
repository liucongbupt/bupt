package offer;

import java.util.List;
import java.util.Stack;

/**
 * @author liucong
 * @ClassName: No5
 * @Description:
 * @date 2017年03月06日 下午9:57
 **/
public class No5 {
    /**
     * 结点对象
     */
    public static class ListNode {
        int val; // 结点的值
        ListNode next; // 下一个结点
    }

    public void printListInverselyUsingIteration(ListNode head){
        Stack<ListNode> stack =new Stack<>();
        while(head!=null){
        stack.add(head);
        head=head.next;}
        ListNode temp ;
        while(!stack.isEmpty()){
            temp = stack.pop();
            printNode(temp);
        }
    }

    public static void printListInverselyUsingRecursion(ListNode root){
        if(root!=null){
            printListInverselyUsingRecursion(root.next);
            printNode(root);
        }
    }
    public static void printNode(ListNode n){
        System.out.println(n.val);
    }
}
