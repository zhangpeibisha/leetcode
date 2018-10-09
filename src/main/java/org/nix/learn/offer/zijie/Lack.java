package org.nix.learn.offer.zijie;

import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/8
 */
public class Lack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        int temp = 0;
        int numberStart = 1;
        int numberEnd = 1;
        for (int i = 0; i < k-1; i++) {
            numberStart *= 10;
        }
        numberEnd = numberStart*10;
        for (int i = numberStart; i < numberEnd; i++) {
            if (haveNumber(String.valueOf(i),String.valueOf(a))!=0 ||
                    haveNumber(String.valueOf(i),String.valueOf(b))!=0){
                if (meili(a,b,i)){
                    temp++;
                }
            }
        }
        System.out.println(temp%1000000007);
    }

    /**
     * 判断一个数是否为美丽
     *
     * @param a     幸运值A
     * @param b     幸运值B
     * @param value 需要检测的数
     * @return 如果是返回true否则返回false
     */
    public static boolean meili(int a, int b, int value) {
        String valueToNumber = String.valueOf(value);
        String temp = valueToNumber;
        // 去除幸运值,证明只包含幸运值
        temp = temp.replace(String.valueOf(a), "");
        temp = temp.replace(String.valueOf(b), "");
        if ("".equals(temp)) {
            // 证明和等于其中一个值
            String tempV = String.valueOf(value);
            // 得出多少个A
            String[] Amber = tempV.replace(String.valueOf(b), ",").split(",");
            int aNumber = 0;
            for (String v : Amber) {
                aNumber += haveNumber(v,String.valueOf(a));
            }
            String[] Bomber = tempV.replace(String.valueOf(a), ",").split(",");
            int bNumber = 0;
            for (String v : Bomber) {
                bNumber += haveNumber(v,String.valueOf(b));
            }
            int sum = aNumber * a + bNumber * b;
            if (sum == a || sum == b) {
                return true;
            }
        }
        return false;
    }

    public static int haveNumber(String one, String two) {
        int counter = 0;
        if (!one.contains(two)) {
            return 0;
        }
        while (one.contains(two)) {
            counter++;
            one = one.substring(one.indexOf(two) + two.length());
        }
        return counter;
    }

}
