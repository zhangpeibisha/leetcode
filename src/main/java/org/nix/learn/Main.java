package org.nix.learn;

import java.util.Scanner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/29
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] sons = input.split(";");
        System.out.println(run(sons[0],sons[1]));
    }

    public static boolean run(String a, String b) {

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int len = charsA.length;

        for (int i = 0; i < len; i++) {
            if (charsA[i] == charsB[0]) {
                if (change(a,i).equals(b)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String change(String value,int i){
        String[] values = {value.substring(0,i),value.substring(i,value.length())};
        return values[1]+values[0];
    }

}
