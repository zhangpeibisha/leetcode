package org.nix.learn.offer.zijie;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/8
 */
public class Backgroup {
    /**
     * 先看钱能买到的最多东西
     * 减去等级最低的，直到达到要求
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int number = in.nextInt();

        List<Zhuang> zhuangs = new ArrayList<>();

        while (in.hasNextInt()){
            Zhuang zhuang = new Zhuang();
            zhuang.val = in.nextInt();
            zhuang.rank = in.nextInt();
            zhuangs.add(zhuang);
        }

        int sNumber = zhuangs.size();
        int[] pics = new int[sNumber];
        int[] ranks = new int[sNumber];
        for (int i = 0; i <sNumber ; i++) {
            Zhuang zhuang = zhuangs.get(i);
            pics[i] = zhuang.val;
            ranks[i] = zhuang.rank;
        }
        Result result = money(money,pics,ranks);
        if (result.indexs.size()>number){
            int cha = result.indexs.size() - number;
            // 倒序排序
            result.indexs.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -(o1-o2);
                }
            });
            Iterator<Integer> iterator = result.indexs.iterator();
            while (iterator.hasNext()&&cha>0){
                result.value = result.value - ranks[iterator.next()];
                iterator.remove();
                cha--;
            }
        }
        System.out.println(result.value);
    }

    /**
     *
     * @param money 拥有的钱
     * @param pic 装备价格
     * @param rank 装备等级
     * @return 最高等级
     */
    public static Result money(int money, int[] pic, int[] rank){
        int n = pic.length;
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] G = new int[n + 1][money + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = pic[i - 1];
            v[i] = rank[i - 1];
        }
        int[] values = new int[money + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int t = money; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }

        int i = n;
        int j = money;
        List<Integer> indexs = new ArrayList<>();
        while (i > 0) {
            if (G[i][j] == 1) {
                indexs.add(i);
                j -= w[i];
            }
            i--;
        }
        return new Result(indexs,values[money]);
    }

    static class Result{
        List<Integer> indexs;
        int value;

        public Result(List<Integer> indexs, int value) {
            this.indexs = indexs;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "indexs=" + indexs +
                    ", value=" + value +
                    '}';
        }
    }

    static class Zhuang{
        int val;
        int rank;
    }
}
