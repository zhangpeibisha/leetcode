package org.nix.learn.use;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/16
 */
public class ThreeSixZero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        List<P> ps = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            P p = new P(in.nextInt(),in.nextInt());
            ps.add(p);
        }
        System.out.println(1);

    }


    public static void init(int m,P[] ps){
        int temp = 0;
        int value = 0;
        Arrays.sort(ps);
        for (P p : ps) {
            if (p.getHe()<m){
                temp++;
            }
        }
    }



    static class P implements Comparable<P>{
        private int trueValue;
        private int falseValue;

        public P(int trueValue, int falseValue) {
            this.trueValue = trueValue;
            this.falseValue = falseValue;
        }

        public int getTrueValue() {
            return trueValue;
        }

        public void setTrueValue(int trueValue) {
            this.trueValue = trueValue;
        }

        public int getFalseValue() {
            return falseValue;
        }

        public void setFalseValue(int falseValue) {
            this.falseValue = falseValue;
        }

        public int getHe(){
            return trueValue+falseValue;
        }

        @Override
        public int compareTo(P o) {
            return getHe()-o.getHe();
        }
    }

}
