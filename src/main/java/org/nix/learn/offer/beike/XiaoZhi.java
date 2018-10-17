package org.nix.learn.offer.beike;

import java.util.Scanner;

/**
 * 小智和小春两个游戏菜鸟要进行电竞搏斗，小智有X点HP，每次攻击会使对方丢失A点生命值，
 * 每次攻击完后需要冷却C秒，小春有Y点HP，每次攻击会使对方丢失B点生命值，
 * 每次攻击完后需要冷却D秒。玩家HP小于等于0时便死亡，若小智最终存活，
 * 则输出XIAOZHI，若小春最终存活，则输出XIAOCHUN，若两者一起死亡，则输出TIE。
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/15
 */
public class XiaoZhi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[6];
        for (int i = 0; i < n; i++) {
            arr[0] = in.nextInt();
            arr[1] = in.nextInt();
            arr[2] = in.nextInt();
            arr[3] = in.nextInt();
            arr[4] = in.nextInt();
            arr[5] = in.nextInt();
            System.out.println(punch(arr));
        }
    }

    public static String punch(int[] arr) {
        int X = (arr[0]);
        int A = (arr[1]);
        int C = (arr[2]);
        int Y = (arr[3]);
        int B = (arr[4]);
        int D = (arr[5]);

        int XLast = -C, YLast = -D, time = 0;
        int Xhp = X, Yhp = Y;

        while (Xhp > 0 && Yhp > 0) {
            if (XLast + C == time) {
                Yhp -= A;
                XLast += C;
            }
            if (YLast + D == time) {
                Xhp -= B;
                YLast += D;
            }
            if (XLast + C >= YLast + D) {
                time = YLast + D;
            } else {
                time = XLast + C;
            }
        }
        if (Xhp <= 0 && Yhp <= 0) {
            return "TIE";
        }
        if (Xhp <= 0) {
            return "XIAOCHUN";
        }
        return "XIAOZHI";
    }

}
