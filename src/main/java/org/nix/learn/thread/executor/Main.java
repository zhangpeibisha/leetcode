package org.nix.learn.thread.executor;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.apache.http.annotation.GuardedBy;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/11
 */
public class Main {

    @GuardedBy(value = "lock")
    private static Integer value = 0;

    private static Object lock = new Object();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int nThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        MyThread thread = new MyThread("加法线程", value,lock);
        for (int i = 0; i < nThreads; i++) {
            executorService.execute(thread);
        }

        // 获取cup数量
        int cpus = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU ====> " + cpus);

        DefaultThreadFactory factory = new DefaultThreadFactory("web服务应用线程池");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10
                , 20
                , 30
                , TimeUnit.MINUTES
                , new PriorityBlockingQueue<>(), factory, new ThreadPoolExecutor.AbortPolicy()
        );
        Future<Object> submit = threadPoolExecutor.submit((java.util.concurrent.Callable<Object>) new Callable());
        long l = System.currentTimeMillis();
        System.out.println(l + " ====>  " + submit.get());

        ArrayList<java.util.concurrent.Callable<Object>> tasks = new ArrayList<>();
        executorService.invokeAll(tasks);


    }

}
