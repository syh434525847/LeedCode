package com.shiyuhao.test;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/11/25 9:54 上午
 **/
public class Ologn {
    public static void main(String[] args) {
        int n = 100;
        int count = 0;
        for (int i = 1; i < n; i = i * 2) {
            ++count;
        }
        System.out.println(count);
    }
}
