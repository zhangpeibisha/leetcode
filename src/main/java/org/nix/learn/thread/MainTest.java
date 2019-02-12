package org.nix.learn.thread;

import java.util.concurrent.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/10
 */
public class MainTest {

    /**
     * 双头队列
     */
    private BlockingDeque blockingDeque = new LinkedBlockingDeque();

    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

    {
        map.putIfAbsent("z", "b");
    }

    public static void main(String[] args) {
        CompletionService completionService = new ExecutorCompletionService(Executors.newCachedThreadPool());

    }

    private static final String A = "";

}
