package org.nix.learn.offer.beike;

import java.util.Scanner;

/**
 * 给你一个合法的算术表达式，只包含整数和加号，减号。但整数不一定都是十进制的数，
 * 可能是八进制，十六进制，规定包含前缀0x的是十六进制，包含前缀0的是八进制，其他情况是十进制。现在你能计算出这个式子最终的值吗？
 *
 * 输入的表达式式子只会是 整数 +(-) 整数 +(-) 整数 …… +(-) 整数
 *
 * 保证给定的整数不会超过6位（包括前缀0或者前缀0x）
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/15
 */
public class MyMath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String value = in.next();
        System.out.println(jiSuan(value));
    }

    public static int jiSuan(String value){
        int result = 0;
        // 首先计算加法
        String[] adds = value.split("\\+");
        for (String v : adds) {
            try {
                result += getTen(v);
            }catch (Exception e){
                // 如果抛出异常说明不是数字而是一个计算公式
                String[] deletes = v.split("-");
                int temp = getTen(deletes[0]);
                for (int i = 1; i < deletes.length ; i++) {
                    temp -= getTen(deletes[i]);
                }
                result += temp;
            }
        }
        return result;
    }

    /**
     * 进制转换为十进制
     * @param value
     * @return
     */
    public static int getTen(String value){
        switch ( getJinZhi(value)){
            case 16 : return Integer.parseInt(value.substring(2),16);
            case 8  : return Integer.parseInt(value,8);
            case 10 : return Integer.parseInt(value);
            default:return -1;
        }
    }

    /**
     * 判断十哪种进制
     * @param value
     * @return
     */
    public static int getJinZhi(String value){

        if (value.contains("0x")){
            return 16;
        }

        if (value.toCharArray()[0] == '0'){
            return 8;
        }

        return 10;
    }

}
