package org.nix.learn.offer.meituan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/9
 */
public class Main {



    public static String result(String che,String reulst,int k,MoneyResult moneyResult,List<Integer> chukai){
        if (k == 0){
            return reulst;
        }
        int index = findMaxMoney(che,moneyResult,chukai);
        return 0+"";
    }

    /**
     * 还原差值最大的几个值,发现一次
     * @param che
     * @return
     */
    public static int findMaxMoney(String che,MoneyResult moneyResult,List<Integer> chukai){
        int Clen = che.length();
        int index = -1;
        int tempV = 999999999;
        char[] chars = che.toCharArray();
        for (int i = 0; i < Clen; i++) {
            if (tempV > money(moneyResult.change,chars[i]) && !have(chukai,i)){
                tempV = money(moneyResult.change,chars[i]);
                index = i;
                moneyResult.money = moneyResult.money- tempV;
            }
        }
        return index;
    }

    public static boolean have(List<Integer> chukai,int i){
        for (int v : chukai) {
            if (v == i){
                return true;
            }
        }
        return false;
    }

    /**
     * 找到全部替换的最小值
     * @param che
     * @param val
     * @return
     */
    public static MoneyResult money(String che, Integer val) {
        // 首先全部替换完毕
        int temp = 0;
        int result = 999999999;
        int value = -1;
        Set<Integer> integers = findNoSame(che);
        char[] chars = che.toCharArray();
        int Clen = chars.length;
        Iterator<Integer> integer = integers.iterator();
        while (integer.hasNext()){
            int v = integer.next();
            for (int i = 0; i < Clen; i++) {
                temp += money(v,chatToInt(chars[i]));
            }
            if (temp<result){
                result = temp;
                value = v;
            }
        }
        MoneyResult moneyResult = new MoneyResult();
        moneyResult.change = value;
        moneyResult.money = result;
        return moneyResult;
    }


    static class MoneyResult {
        int money;
        /**
         * 替换成的数字
         */
        int change;
    }

    /**
     * 找出车牌中的所有数字
     *
     * @return
     */
    public static Set<Integer> findNoSame(String che) {
        int len = che.length();

        Set<Integer> set = new HashSet<>(len);
        char[] chars = che.toCharArray();
        for (char c : chars) {
            set.add(chatToInt(c));
        }
        return set;
    }

    /**
     * char 转为 int
     *
     * @param c
     * @return
     */
    public static int chatToInt(char c) {
        return c - '0';
    }

    /**
     * 换号码需要的钱
     *
     * @param a
     * @param b
     * @return
     */
    public static int money(int a, int b) {
        int temp = a - b;
        return temp > 0 ? temp : -temp;
    }

}
