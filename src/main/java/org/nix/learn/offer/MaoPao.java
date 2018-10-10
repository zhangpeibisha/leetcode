package org.nix.learn.offer;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/10
 */
public class MaoPao {

    public static void main(String[] args) {
        for (int a : serch(new int[]{1,7,8,2, 7, 11, 15},9)) {
            System.out.print(a + " ");
        }
    }

    public static int[] maopao(int[] a) {

        if (a == null) {
            return new int[]{};
        }

        int len = a.length;
        if (len == 0 || len == 1) {
            return a;
        }
        for (int i = 0; i < len - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }

    public static int[] serch(int[] arr, int target) {
        if (arr == null || arr.length<=2){
            return new int[]{};
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i]<target){
                for (int j = i+1; j < len; j++) {
                    if (arr[i] + arr[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return new int[]{};
    }


}
