package org.nix.learn.offer.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/8
 */
public class Main {

    //上下左右移动

    static int[][] temp = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 最短多少步
        int len = in.nextInt();
        List<List<Integer>> roads = new ArrayList<>();

        while (in.hasNextInt()) {
            List<Integer> v = new ArrayList<>();
            roads.add(v);
            while (in.hasNextInt()) {
                v.add(in.nextInt());
            }
        }
        int x = roads.get(0).size();
        int y = roads.size();

        int[][] road = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                road[i][j] = roads.get(i).get(j);
            }
        }

        List<Index> people = find(road, x, y, 0);
        List<Index> exits = find(road, x, y, 1);
        int[][] temp = road;
        boolean flag = false;
        for (Index index : people) {
            flag = false;
            for (Index exit : exits) {
                int[][] book = new int[x][y];
                book[0][0] = 1;
                if (dfs(index.x, index.y, exit.x, exit.y, 0, x, y, 0, book, road) <= len) {
                    temp[index.x][index.y] = 0;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                temp[index.x][index.y] = 1;
            }
        }

    }

    /**
     * 发现指定值的坐标
     *
     * @param road
     * @param x
     * @param y
     * @param value
     * @return
     */
    public static List<Index> find(int[][] road, int x, int y, int value) {
        List<Index> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (road[i][j] == value) {
                    list.add(new Index(i, j));
                }
            }
        }
        return list;
    }

    public static int dfs(int startx, int starty,
                          int endx, int endy,
                          int step,
                          int xnumber, int ynumber,
                          int min,
                          int[][] book,
                          int[][] road) {
        //如果到达地点，结束
        if (endx == startx && endy == starty) {
            if (step < min) {
                min = step;
            }
            return min;
        }
        //循环移动到四个方向
        for (int i = 0; i < 4; i++) {
            int tx = temp[i][0];
            int ty = temp[i][1];
            //如果该方向越界了，改变到另一个方向
            if (endx + tx < 0 || endx + tx >= xnumber) {
                continue;
            }

            if (endy + ty < 0 || endy + ty >= ynumber) {
                continue;
            }
            //如果该位置没有墙并且也没有走过，走
            if (road[endx + tx][endy + ty] == 0 && book[endx + tx][endy + ty] == 0) {
                //标记为走过
                book[endx + tx][endy + ty] = 1;
                //往下一层递归
                dfs(endx + tx, endy + ty, endx, endy, step + 1, xnumber, ynumber, min, book, road);
                //取消标记，回到上一层
                book[endx + tx][endy + ty] = 0;
            }
        }
        return min;
    }

    static class Index {
        int x;
        int y;

        public Index() {
        }

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
