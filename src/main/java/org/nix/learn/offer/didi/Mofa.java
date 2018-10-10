package org.nix.learn.offer.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/10
 */
public class Mofa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[] baoshi = new int[m];
        for (int i = 0; i < m; i++) {
            baoshi[i] = in.nextInt();
        }
        System.out.println(sum(baoshi,n));
    }

    /**
     * 合成
     *
     * @param baoshi 宝石属性
     * @param n      合成次数
     * @return 法强强度
     */
    public static int sum(int[] baoshi, int n) {
        if (n == 0) {
            return baoshi[0];
        }
        int len = baoshi.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return baoshi[0];
        }
        if (len == 2) {
            return baoshi[0] + baoshi[1];
        }
        Arrays.sort(baoshi);
        int temp = 999999999;
        int index = 2;
        while (true){
            if (temp > baoshi[len-1]){
                try {
                    temp = baoshi[0] + baoshi[len - index++];
                }catch (IndexOutOfBoundsException e){
                  // 说明越界了，一次需要调整最大值
                  temp = baoshi[0] + baoshi[len - 1];
                  index = 1;
                    System.out.println("越界");
                  break;
                }
            }else {
                break;
            }
        }
        List<Integer> integers = new ArrayList<>(len - 1);
        for (int i = 0; i < len; i++) {
            if (i != 0 && i != len - index) {
                integers.add(baoshi[i]);
            }
        }
        integers.add(temp);
        n--;
        len = integers.size();
        int[] result = new int[len];
        for (int i = 0; i < len ; i++) {
            result[i] = integers.get(i);
        }
        Arrays.sort(result);
        return sum(result, n);
    }
}
