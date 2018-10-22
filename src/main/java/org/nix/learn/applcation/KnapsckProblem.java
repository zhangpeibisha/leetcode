package org.nix.learn.applcation;

/**
 * 背包问题
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/22
 */
public class KnapsckProblem {

    public static void main(String[] args) {
        int[] w = {3, 4, 5};
        int[] v = {4, 5, 6};
        runMaxValue(w, v, 10);

    }

    /**
     * 求规定一个包的容龄，一个物品的价值和重量得出怎么装的最多价值的物品
     *
     * @param w 物品的重量
     * @param v 物品的价值
     * @param p 背包的容量
     * @return 能够装的最大价值
     */
    public static int runMaxValue(int[] w, int[] v, int p) {
        int len = w.length;
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] c = new int[len + 1][p + 1];
        //填表，i表示放哪个物品，j表示重量，c[i][j]表示放置在J重量的背包里的最大价值
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < p + 1; j++) {
                // 如果第i-1个物品的重量没有超过背包重量则可能放入，否则当前价值等于不放入的价值
                if (w[i - 1] <= j) {
                    // 如果上一个物品的价值 小于
                    // 上一个物品放入（j-已经放入的空间）的价值c[i-1][j-w[i-1]](这是已经求出的最大值)+当前物品的价值
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + v[i - 1])) {
                        // 设置放置的值为新加入的值
                        c[i][j] = c[i - 1][j - w[i - 1]] + v[i - 1];
                    }
                    // 否则不放入物品
                    else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        printArr(c);
        return 0;
    }

    public static void printArr(int[][] arr) {
        //第一行和第一列为0
        for (int[] curr : arr) {
            for (int value : curr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}
