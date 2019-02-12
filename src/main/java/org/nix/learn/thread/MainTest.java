package org.nix.learn.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/10
 */
public class MainTest {

    private BlockingDeque blockingDeque = new LinkedBlockingDeque();

    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

    {
        map.putIfAbsent("z", "b");
    }

    private static final String A = "";

}
