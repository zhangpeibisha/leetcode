package org.nix.learn.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangpei
 * @version 1.0
 * @description 闭锁学习
 * @date 2019/2/10
 */
public class MyyCountDownLatch {

    public long timeTasks(int threads, final Runnable task) throws InterruptedException {
        // 启动门
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束门
        final CountDownLatch endGate = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 全部线程在这儿先等着
                    startGate.await();
                    try {
                        // 开始执行
                        task.run();
                    } finally {
                        // 执行完后表示这该线程已经准备好 了
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                }
            });
            thread.start();
        }

        long start = System.currentTimeMillis();
        // 放行所有线程执行
        startGate.countDown();
        // 等待所有线程执行结束后放行
        endGate.await();
        // 统计结束的时间
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable zhangpei = () -> System.out.println("zhangpei"+Thread.currentThread().getName());
        MyyCountDownLatch myyCountDownLatch = new MyyCountDownLatch();
        long l = myyCountDownLatch.timeTasks(20, zhangpei);
        System.out.println(l);
    }

}
