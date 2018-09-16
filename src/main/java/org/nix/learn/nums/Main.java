package org.nix.learn.nums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/16
 */
public class Main {

    public static boolean can(int a,int b,int c){

        if (b/a==0&&c/a==0){
            if (c == (a+b+c)%b){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        Road one = new Road(2,1);
//        Road tow = new Road(3,2);
//        Road three = new Road(4,3);
//
//        List<Road> roads = new ArrayList<>();
//        roads.add(one);
//        roads.add(tow);
//        roads.add(three);
//
//        System.out.println(formTo(roads,1));
//        System.out.println(toForm(roads,1));

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int number = n*3;

        for (int i = 0; i <number ; i++) {
            int value = scanner.nextInt();
        }

        // 城市数量
        int x = scaner.nextInt();
        // 道路数量x
        int m = scanner.nextInt();

        List<Road> roads = new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Road road = new Road(start,end);
            roads.add(road);
        }

        int temp = 0;
        for (int i = 0; i <n ; i++) {
            System.out.println(i+" 起点到终点："+formTo(roads,i));
            System.out.println(i+" 终点到起点:"+toForm(roads,i));
            if (formTo(roads,i)>toForm(roads,i)){
                temp++;
            }
        }
        System.out.println(temp);
    }

    /**
     * 从一个城市到另外一个城市有多少条道路
     * @return
     */
    public static int formTo(List<Road> roads,int start){
        int temp = 0;
        int len = roads.size();
        for (int i = 0; i <len ; i++) {
            if (daoDaStart(roads,start,i)){
                temp++;
            }
        }
        return temp;
    }
    public static boolean daoDaStart(List<Road> roads,int statr,int end){
        for (Road road : roads) {
            if (road.form == statr){
                if (road.to == end){
                    return true;
                }else {
                    daoDaStart(roads,road.to,end);
                }
            }
        }
        return false;
    }
    /**
     * 求这个城市有多少城市可以到达
     * @param roads
     * @param form
     * @return
     */
    public static int toForm(List<Road> roads,int form){
        int temp = 0;
        int len = roads.size();
        for (int i = 0; i <len ; i++) {
            if (daoDaTo(roads,i,form)){
                temp++;
            }
        }
        return temp;
    }
    public static boolean daoDaTo(List<Road> roads,int statr,int end){
        for (Road road : roads) {
            if (road.to == end){
                if (road.form == statr){
                    return true;
                }else {
                    daoDaStart(roads,road.form,end);
                }
            }
        }
        return false;
    }


    static class Road{
        private int form;

        private int to;

        public Road(int form, int to) {
            this.form = form;
            this.to = to;
        }

        public int getForm() {
            return form;
        }

        public void setForm(int form) {
            this.form = form;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }

}
