package org.nix.learn.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/20
 */
public class Main1 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        List<String> values = new ArrayList<>();
        while (true){
            String value = in.next();
            if ("END".equals(value)){
                break;
            }
            values.add(value);
        }

        int len = values.size();
        boolean flag = false;

        for (int i = 0; i <len; i++) {
            for (int j = 0; j <len ; j++) {
                if (getValue(values.get(i)) == getValue(values.get(j)) && i!=j){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(values.get(i));
            }else {
                flag = false;
            }
        }

    }

    public static int getValue(String value) throws Exception {
       try {
           String[] son = value.split("#");
           int jinzhi = Integer.parseInt(son[0]);
           String zhi = son[1];
           return parseInt(zhi,jinzhi);
       }catch (Exception e){
           throw new Exception("输入格式异常");
       }
    }

    public static int parseInt(String s, int radix)
            throws Exception {
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+'){
                    throw new Exception(s);
                }
                if (len == 1){
                    throw new Exception(s);
                }
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new Exception(s);
                }
                if (result < multmin) {
                    throw new Exception(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new Exception(s);
                }
                result -= digit;
            }
        } else {
            throw new Exception(s);
        }
        return negative ? result : -result;
    }
}
