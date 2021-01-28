package com.shiyuhao.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/22 上午11:10
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolUtils.newThreadPool("testPool", false, 10, 20, 3,
                new ArrayBlockingQueue<>(1000), new NamedThreadFactory("testThread"));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());

            });
        }

    }
}
