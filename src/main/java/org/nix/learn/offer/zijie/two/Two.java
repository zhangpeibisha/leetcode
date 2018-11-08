package org.nix.learn.offer.zijie.two;

import java.util.Scanner;

/**
 * 第二次字节笔试
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/5
 */
public class Two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(value(a,b));
    }

    public static int value(int a,int b){
        int result = 0;
        if (a <= b){
            for (int i = 1; i <= b ; i++) {
                result += a/i;
            }
            return result;
        }
        int tempASum = 0;
        for (int i = 1; i <= a ; i++) {
            tempASum += i;
        }
        result = tempASum;
        return result;
    }

}
