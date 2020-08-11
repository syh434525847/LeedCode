package com.shiyuhao.leetcode;

import com.shiyuhao.common.ListNode;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/6/24 10:46 上午
 **/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node1);
        while (true) {
            System.out.println(node.val);
            node = node.next;
            if (node == null) {
                break;
            }
        }
    }
    public void deleteNode(ListNode node) {
        // 本身的值替换成下一个的值，然后将下一个node删除即可
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
