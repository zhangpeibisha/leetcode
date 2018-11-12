package org.nix.learn.offer.pdd;

import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class One {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(run(input));
    }


    public static int run(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] index = new int[26];
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            index[getIndex(chars[i])]++;
        }
        paixu(index);
        int temp = 0;
        for (int i = 1; i < 26; i++) {
            if (i == 1) {
                temp += (index[0] + index[1]) * (index[0] + index[1]);
                continue;
            }
            temp += index[i] * index[i];
        }
        return temp;
    }

    public static int getIndex(char c) {
        return c - 'a';
    }

    public static void paixu(int[] index) {
        int len = index.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (index[j] < index[j + 1]) {
                    int temp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp;
                }
            }
        }
    }
}
