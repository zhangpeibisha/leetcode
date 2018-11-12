package org.nix.learn.utils;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/12
 */
public class C {

    public static void main(String[] args) {
        method(1);
        method(new Integer(1));
    }

    public static void method(Integer val, int val2) {
        System.out.println("Integer");
    }

    public static void method(int val2, Integer val) {
        System.out.println("Integer");
    }

    public static void method(Integer val) {
        System.out.println("Integer");
    }

    public static void method(Integer... val) {
        System.out.println("Integer...");
    }

    public static void method(long val) {
        System.out.println("long");
    }

    public static void method(String val) {
        System.out.println("String");
    }

    public static void method(int val) {
        System.out.println("int");
    }

    public static void method(Object val) {
        System.out.println("Object");
    }


}
