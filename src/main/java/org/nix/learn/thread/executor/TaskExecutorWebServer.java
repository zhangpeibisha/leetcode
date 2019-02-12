package org.nix.learn.thread.executor;

import java.util.Stack;
import java.util.concurrent.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基于Executor框架的web服务器
 * @date 2019/2/10
 */
public class TaskExecutorWebServer extends Callable implements Executor {

    private ExecutorService executor = new ThreadPoolExecutor(10,
            10,
            20,
            TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(),
            (ThreadFactory) r -> null, (r, executor) -> {
    });

    @Override
    public void execute(Runnable command) {
        // 获取固定的线程池
        Executors.newFixedThreadPool(10);
        // 双头队列
        DelayQueue<Delayed> delayQueue;
        // 自定义线程池提交任务
        executor.execute(command);
        //
        Future<?> submit = executor.submit(command);
        try {
            try {
                submit.get(12, TimeUnit.MINUTES);
            } catch (TimeoutException e) {
                System.out.println("使用默认数据");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        CompletionService completionService = new ExecutorCompletionService(executor);
        completionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return "";
            }
        });

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        Integer pop = stack.pop();
        System.out.println(pop);
        pop = stack.peek();
        System.out.println(pop);
    }

    @Override
    public Object call() throws Exception {
        ConcurrentHashMap concurrentHashMap;

        return null;
    }
}
