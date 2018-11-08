package org.nix.learn.offer.zijie.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/5
 */
public class Three {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] n = new int[N];
        int one = in.nextInt();
        int tow = in.nextInt();
        for (int i = 0; i <N ; i++) {
            n[i] = in.nextInt();
        }
        System.out.println(run(one, tow, n));
    }

    /**
     * @param one 主伤害
     * @param two 次要伤害
     * @param n   怪兽
     * @return 次数
     */
    public static int run(int one, int two, int[] n) {
        // 第一个怪承受主伤害，后续怪兽承受次要伤害
        int len = n.length;
        int number = 0;
        while (!exit(n)) {
            paixu(n);
            int temp = n[0] - one;
            if (temp <= 0) {
                n[0] = 0;
            } else {
                n[0] = temp;
            }
            for (int i = 1; i < len; i++) {
                if (n[i] == 0) {
                    continue;
                }
                temp = n[i] - two;
                if (temp <= 0) {
                    n[i] = 0;
                } else {
                    n[i] = temp;
                }
            }
            number++;
        }
        return number;
    }

    public static boolean exit(int[] n) {
        for (int v : n) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    public static void paixu(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            for (int j = 0; j < n.length - 1 - i; j++) {
                if (n[j] < n[j + 1]) {
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }
    }

}
