package org.nix.learn.utils;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class A {

    static {
        System.out.println("父类静态模块 A");
    }

    public A() {
        System.out.println("父类构造模块");
    }

    public void method(){
        System.out.println("父类方法模块");
    }
}
