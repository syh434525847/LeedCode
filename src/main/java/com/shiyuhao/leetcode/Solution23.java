package com.shiyuhao.leetcode;

import com.shiyuhao.common.ListNode;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/21 下午5:44
 **/
public class Solution23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l = new ListNode(2);
        lists[0] = l;
        lists[1] = null;
        lists[2] = new ListNode(-1);
        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        if(lists.length == 2) {
            return merge(lists[0], lists[1]);
        }
        ListNode res = merge(lists[0], lists[1]);
        for(int i =2;i<lists.length;i++) {
            res = merge(res, lists[i]);
        }
        return res;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if(l1 == null) {
            res.next = l2;
        } else if(l2 == null) {
            res.next = l1;
        }

        return temp.next;
    }
}
