package org.nix.learn.jvm;

/**
 * @author zhangpei
 * @version 1.0
 * @description volatile学习
 * @date 2019/2/13
 */
public class Singleton {

    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }

}
