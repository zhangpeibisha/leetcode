package org.nix.learn.offer.beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/15
 */
public class M {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int n = in.nextInt(), m = in.nextInt();
        System.out.println(run(n,m));
    }

    public static int run(int n, int m) {
        // 有多少个质因数
        int number = getZhiShu(m);
        return zuhe(number,n);
    }

    public static int zuhe(int n , int m){
        return 0;
    }

    public static int jisuan(int n,int m){
        int temp = 0;
        for (int i = n; i >0 ; i--) {
            temp *= (m-i);
        }
        return temp;
    }

    public static boolean isPrime(int i) {
        boolean isPrime = true;
        //除到i的平方根就可以判断
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    /**
     * 得到质数
     *
     * @param value
     * @return
     */
    public static int getZhiShu(int value) {
        int temp = 1;
        if (isPrime(value)) {
            return ++temp;
        } else {
            for (int i = 2; i <= value; i++) {
                while (value != i) {
                    if (value % i == 0) {
                        value = value / i;
                        temp++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ++temp;
    }

}
