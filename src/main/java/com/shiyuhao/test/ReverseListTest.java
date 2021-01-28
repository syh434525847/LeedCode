package com.shiyuhao.test;

import com.shiyuhao.common.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/15 下午5:20
 **/
public class ReverseListTest {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(1);
        boolean reverse = isPalindrome(list);
        System.out.println(reverse);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        for (int i =0;i<k;i++) {
            p = p.next;
        }
        while(p.next !=null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode p = head;
        ListNode q = newHead;
        while(p != null) {
            if(p.val != q.val) {
                return false;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return true;
    }


}
