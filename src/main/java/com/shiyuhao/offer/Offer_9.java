package com.shiyuhao.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 两个栈实现队列
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/23 10:51 上午
 **/
public class Offer_9 {
    public static void main(String[] args) {
        CQueue<String> cQueue = new CQueue<>();
        cQueue.appendTail("a");
        cQueue.appendTail("b");
        cQueue.appendTail("c");
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail("d");
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }

    /**
     * 两个栈实现队列
     **/
    static class CQueue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        void appendTail(T t) {
            stack1.push(t);
        }

        T deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    T stack1Pop = stack1.pop();
                    stack2.push(stack1Pop);
                }
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return null;
        }
    }

    /**
     * 两个队列实现栈
     **/
    static class CStack<T> {
        private Queue<T> queue1 = new LinkedList<>();
        private Queue<T> queue2 = new LinkedList<>();


    }
}
