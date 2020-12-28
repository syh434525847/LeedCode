package com.shiyuhao.offer;

import com.shiyuhao.common.ListNode;

import java.util.Stack;

/**
 * @Description 链表，反向打印链表数据，从尾节点开始打印数据
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/21 4:25 下午
 **/
public class Offer_6 {
    public static void main(String[] args) {
        // 1 --> 2 --> 3 --> 4 --> 5 --> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        printFromTailByStack(head);
    }

    public static void printFromTailByStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void printFromTail(ListNode node) {
        if (node == null) {
            return;
        }
        printFromTail(node.next);
        System.out.print(node.val + " ");
    }
}
