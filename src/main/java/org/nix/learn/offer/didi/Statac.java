package org.nix.learn.offer.didi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/10
 */
public class Statac {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] number = new int[4];
        for (int i = 0; i < 4; i++) {
            number[i] = in.nextInt();
        }
        System.out.println(test(number));
    }

    public static String test(int[] number){
        Stack<Integer> stack = new Stack<>();
        int[] value = new int[]{1,2,3,4};
        int temp = 0;
        for (int v : value) {
            stack.push(v);
            while (true){
                if (!stack.empty()){
                    // 如果栈顶相等，则弹出，并坐标加+1
                    if (stack.peek() == number[temp]){
                        stack.pop();
                        temp++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return temp == 4?"Yes":"No";
    }

}
