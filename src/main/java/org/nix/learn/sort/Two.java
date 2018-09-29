package org.nix.learn.sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 清雨又在吃自助餐了。
 *
 * 排在清雨面前的有N种食物，排成一排，清雨可以选择其中的若干种食物，但是不能连续选择相邻的食物。因为清雨很挑食，当所有食物都不合口味时，他可以一种都不选，即一个都不选也算为一种方法。
 *
 * 请问他有多少种选择食物的方法呢？
 *
 * 输入
 * 一个整数n（1 <= n <= 90）
 *
 * 输出
 * 一个正整数表示答案
 *
 *
 * 样例输入
 * 3
 * 样例输出
 * 5
 *
 * Hint
 * 样例解释：有3种食物，方案为1、2、3、13、不选，共5种
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/28
 */
public class Two {

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(getMethod(n));
        int[] a = {1,2,1,2};
//        System.out.println(combine(0,a.length-1,a,0));
    }

    public static int getMethod(int value){

        int temp1 = 0;
        int temp2 = 0;
        int temp = 0;

        // 找到不相邻的值的个数
        if (value/2==0){
            temp1 = value/2;

        }else {
            temp1 = value/2;
            temp2 = temp1+1;
        }
        return temp+value;
    }



}
