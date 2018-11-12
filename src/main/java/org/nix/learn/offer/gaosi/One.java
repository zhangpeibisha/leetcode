package org.nix.learn.offer.gaosi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/9
 */
public class One {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test = in.next();
        if (run(test)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean run(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
           join(chars[i],stack);
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void join(char c,Stack<Character> stack) {
        if (c == ']' || c == ')' || c == '}'){
            if (!stack.isEmpty() && kuoHao(c) == stack.peek()){
                stack.pop();
            }
        }
        else {
            stack.push(c);
        }
    }

    public static char kuoHao(char c) {
        switch (c) {
            case ']':
                return '[';
            case ')':
                return '(';
            case '}':
                return '{';
            default:
                throw new RuntimeException("括号匹配异常");
        }
    }
}
