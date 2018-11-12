package org.nix.learn.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class B extends A{

    static {
        System.out.println("子类静态模块");
    }

    {
        System.out.println("子类模块==========");
    }

    public B() {
        System.out.println("子类构造函数模块");
    }

    @Override
    public void method() {
        System.out.println("子类方法模块");
    }

    public static void main(String[] args) {
        A a = new B();
        a.method();
        System.out.println();
        new B();
        ConcurrentHashMap concurrentHashMap;
        Queue queue;
        ReentrantLock reentrantLock;
        StringBuilder builder;
        StringBuffer buffer;
    }
}
