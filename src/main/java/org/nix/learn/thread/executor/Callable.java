package org.nix.learn.thread.executor;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/11
 */
public class Callable extends Thread implements java.util.concurrent.Callable {

    @Override
    public Object call() throws Exception {
        sleep(1000);
        return "返回数据"+System.currentTimeMillis();
    }
}
