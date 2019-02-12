package org.nix.learn.thread.executor;

import com.sun.xml.internal.ws.api.Cancelable;
import org.apache.http.annotation.GuardedBy;

import java.util.concurrent.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 线程学习
 * @date 2019/2/11
 */
public class MyThread extends Thread  {

    int value;

    private final Object lock;

    public MyThread(String name, int value, Object lock) {
        super(name);
        this.value = value;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            value++;
            System.out.println(value);
        }
    }
}
