package org.nix.learn.nums;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/16
 */
public class Solution {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     * 输入: "hello"
     * 输出: "olleh"
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] value = s.toCharArray();
        int len = value.length;
        char[] res = new char[len];
        int resIndex = len-1;
        for (int i = 0; i <len; i++) {
            res[resIndex] = value[i];
            resIndex--;
        }
        return new String(res);
    }

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] chai = s.split(" ");
        int len = chai.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(reverseString(chai[i])).append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 输入: "()"
     * 输出: true
     *
     * 输入: "([)]"
     * 输出: false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] kuohao = s.toCharArray();
        int len = kuohao.length;
        Stack<Character> stack = new Stack<>();
        for (Character c : kuohao) {
            if (stack.size()!=0&&c.equals(kuohaoFan(stack.peek()))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public Character kuohaoFan(Character c){
        switch (c){
            case '{':return '}';
            case '[':return ']';
            case '(':return ')';
            default:return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getM(n));
    }

    public static int getM(int n){
        int m = n+1;
        while (true) {
            int[] nm = getArr(n+1,m);
            int[] zerom = getArr(1,m);
            if (getMoreSmallMul(nm,nm.length) == getMoreSmallMul(zerom,zerom.length)){
                return m;
            }else {
                m++;
            }
        }
    }

    /**
     * 创建指定范围的数组
     * @param start
     * @param end
     * @return
     */
    public static int[] getArr(int start,int end){
        int len = end-start+1;
        int[] value = new int[len];
        for (int i = 0; i <len ; i++) {
            value[i] = start++;
        }
        return value;
    }

    /**
     * 求两个数的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getBigDiv(int a, int b) {
        if (b == 0){
            return a;
        }
        return getBigDiv(b, a % b);
    }

    /**
     * 求两个数的最小公倍数
     * @param a
     * @param b
     * @return
     */
    public static int getSmallMul(int a, int b) {
        return (a * b) / getBigDiv(a, b);
    }

    /**
     * 求多个数的最大公约数
     * @param num
     * @param n
     * @return
     */
//    public static int getMoreBigDiv(int num[], int n) {
//        if (n == 1){
//            return num[n - 1];
//        }
//        return getBigDiv(num[n - 1], getMoreBigDiv(num, n - 1));
//    }

    /**
     * 求多个数的最小公倍数
     * @param num
     * @param n
     * @return
     */
    public static int getMoreSmallMul(int num[], int n) {
        if (n == 1){
            return num[n - 1];
        }
        return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
    }

}
