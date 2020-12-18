package com.shiyuhao.test;

import com.shiyuhao.common.ListNode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/11/25 12:35 下午
 **/
public class ListTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
