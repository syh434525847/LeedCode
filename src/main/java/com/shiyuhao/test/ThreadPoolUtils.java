package com.shiyuhao.test;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/22 上午11:03
 **/
public class ThreadPoolUtils {
    private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();

    public static ThreadPoolExecutor newThreadPool(final String poolName, final boolean enableMetric,
                                                   final int coreThreads, final int maximumThreads,
                                                   final long keepAliveSeconds,
                                                   final BlockingQueue<Runnable> workQueue,
                                                   final ThreadFactory threadFactory) {
        return newThreadPool(poolName, enableMetric, coreThreads, maximumThreads, keepAliveSeconds, workQueue,
                threadFactory, defaultHandler);
    }

    private static ThreadPoolExecutor newThreadPool(String poolName, boolean enableMetric, int coreThreads, int maximumThreads, long keepAliveSeconds, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler defaultHandler) {
        final TimeUnit unit = TimeUnit.SECONDS;
        return new ThreadPoolExecutor(coreThreads, maximumThreads, keepAliveSeconds, unit, workQueue, threadFactory, defaultHandler);
    }

}
