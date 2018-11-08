package org.nix.learn.offer.zijie.two;

import org.nix.learn.offer.beike.M;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/5
 */
public class a {

    public static void main(String[] args) {
        int n = 4;
        int l = 8;
        int t = 6;
        Mayi[] mayis = {
                new Mayi(6, true),
                new Mayi(5, false),
                new Mayi(1, true),
                new Mayi(8, true)};
        run(mayis, l, t);
        for (Mayi mayi : mayis) {
            System.out.print(mayi.index + " ");
        }
    }

    public static void run(Mayi[] mayis, int l, int t) {
        if (t == 0) {
            return;
        }
        run(mayis, l);
        run(mayis, l, --t);
    }

    /**
     * 蚂蚁跑一秒
     */
    public static void run(Mayi[] mayis, int l) {
        diaoTou(mayis);
        int temp;
        int len = mayis.length;
        for (int i = 0; i < len ; i++) {
            Mayi tempM = mayis[i];
            for (int j = 0; j <len && j !=i; j++) {
                temp = tempM.index - mayis[j].index;
                // 位子不移动，方向相反
                if (Math.asin(temp) == 1) {
                    tempM.fangxiang = !tempM.fangxiang;
                    mayis[j].fangxiang = !mayis[j].fangxiang;
                }
                // 如果位子相同，向左右移动一个单位
                if (temp == 0) {
                    // 掉头
                    tempM.fangxiang = !tempM.fangxiang;
                    mayis[j].fangxiang = !mayis[j].fangxiang;
                    remove(mayis[i], l);
                    remove(mayis[j], l);
                }
                if (Math.asin(temp) != 1 && temp != 0) {
                    remove(tempM, l);
                    remove(mayis[j], l);
                }
            }
        }
    }

    public static void remove(Mayi mayi, int l) {
        int temp;
        if (mayi.fangxiang) {
            temp = mayi.index++;
            if (temp > l) {
                mayi.index = 1;
            } else {
                mayi.index = temp;
            }
        } else {
            temp = mayi.index--;
            if (temp < 1) {
                mayi.index = l;
            } else {
                mayi.index = 1;
            }
        }
    }

    /**
     * 设置掉头
     *
     * @param mayis
     */
    public static void diaoTou(Mayi[] mayis) {
        Mayi temp;
        int len = mayis.length;
        for (int i = 0; i < len; i++) {
            temp = mayis[i];
            for (int j = 0; j < len && j != i; j++) {
                int tempM = temp.index - mayis[j].index;
                if (temp.fangxiang != mayis[j].fangxiang) {
                    if (tempM == 0) {
                        temp.fangxiang = !temp.fangxiang;
                        mayis[j].fangxiang = !mayis[j].fangxiang;
                    }
                }
            }
        }
    }

    /**
     * true 是顺时针
     * false 是逆时针
     */
    static class Mayi {
        int index;
        boolean fangxiang;

        public Mayi(int index, boolean fangxiang) {
            this.index = index;
            this.fangxiang = fangxiang;
        }
    }
}
