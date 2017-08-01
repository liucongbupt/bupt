package leetcode.sort.LinkedList;

/**
 * @author liucong
 * @ClassName: No445AddTwoNumbersII
 * @Description:
 * @date 2017年03月08日 下午5:08
 **/

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class No445AddTwoNumbersII {
    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode newHead = new ListNode(0);
        ListNode p1=l1,p2=l2,p3=newHead;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(p1!=null){
            s1.push(p1);
            p1=p1.next;
        }
        while(p2!=null){
            s2.push(p2);
            p2=p2.next;
        }
        int carry=0;
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()){
                carry+=s1.pop().val;
            }
            if (!s2.isEmpty()){
                carry+=s2.pop().val;
            }

            ListNode node = new ListNode(carry%10);
            node.next=p3.next;
            p3.next=node;
            carry/=10;
        }
        if(carry==1){
            ListNode node = new ListNode(1);
            node.next=p3.next;
            p3.next=node;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(7);
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        p1.next=p2;
        p2.next=p3;
        addTwoNumbers(l1,p1);

    }
}
