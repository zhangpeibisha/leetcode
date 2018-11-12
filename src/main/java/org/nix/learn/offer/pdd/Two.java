package org.nix.learn.offer.pdd;

import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class Two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ver1 = in.next();
        String ver2 = in.next();
        System.out.println(run(ver1, ver2));
    }

    public static int run(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int ver1Len = ver1.length;
        int ver2Len = ver2.length;
        int temp = ver1Len > ver2Len ? ver2Len : ver1Len;
        for (int i = 0; i < temp; i++) {
            int val = Integer.valueOf(ver1[i]) - Integer.valueOf(ver2[i]);
            if (val == 0) {
                continue;
            }
            if (val > 0) {
                return 1;
            }
            if (val < 0) {
                return -1;
            }
        }
        if (ver1Len == ver2Len) {
            return 0;
        }
        return temp == ver1Len ? -1 : 1;
    }

}
