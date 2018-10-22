package org.nix.learn.applcation;

import java.util.Scanner;

/**
 * 完成双截棍字符串，
 * 左边和右边字符长度相同，中间字符长度下雨左右两边的字符串长度
 * 求最长的双截棍字符串
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();
        System.out.println("值为：" + function(value));
    }

    public static String function(String value) {
        char[] valueArr = value.toCharArray();
        int len = valueArr.length;

        int tempStart;
        int tempEnd;

        int start = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            int self = haveSelf(i, valueArr);
            int left = haveLeft(i, valueArr);
            int rigth = haveRigth(i, valueArr);

            if (self >= 0 && self < left && self < rigth) {
                int min = Math.min(left, rigth);
                tempStart = i - min - (haveSelfLigth(i,valueArr)-1);
                tempEnd = i + (haveSelfRight(i,valueArr)-1) + min;
                if ((end - start) < (tempEnd - tempStart)) {
                    start = tempStart;
                    end = tempEnd;
                }
            }
        }
        return value.substring(start, end+1);
    }


    public static int haveSelf(int currIndex, char[] value) {
        return haveSelfLigth(currIndex, value) + haveSelfRight(currIndex, value) - 1;
    }

    public static int haveSelfLigth(int currIndex, char[] value) {

        int len;
        len = value.length;
        char curr;
        curr = value[currIndex];
        int temp = 0;

        for (int i = currIndex; i >= 0; i--) {
            if (curr == value[i]) {
                temp++;
            } else {
                break;
            }
        }

        return temp;

    }

    public static int haveSelfRight(int currIndex, char[] value) {
        int len;
        len = value.length;
        char curr;
        curr = value[currIndex];
        int temp = 0;

        // 1.找自己有多少个
        for (int i = currIndex; i < len; i++) {
            if (curr == value[i]) {
                temp++;
            } else {
                break;
            }
        }
        return temp;
    }

    public static int haveRigth(int currIndex, char[] value) {
        int len;
        len = value.length;
        char curr;
        curr = value[currIndex];
        int temp = 0;

        // 3.找坐标右边有多少个不同
        int index = currIndex + haveSelfRight(currIndex, value);
        if (index >= 0 && index < len) {
            curr = value[index];
            for (int i = index; i < len; i++) {
                if (curr == value[i]) {
                    temp++;
                } else {
                    break;
                }
            }
        }
        return temp;
    }


    public static int haveLeft(int currIndex, char[] value) {
        int len;
        len = value.length;
        char curr;
        curr = value[currIndex];
        int temp = 0;
        int index;
        // 2.找坐标有多少个不同的
        if ((index = currIndex - haveSelfLigth(currIndex, value)) >= 0) {
            curr = value[index];
            for (int i = index; i >= 0; i--) {
                if (curr == value[i]) {
                    temp++;
                } else {
                    break;
                }
            }
        }
        return temp;
    }

}

class Result {
    private String result;
    /**
     * 前缀开始坐标
     */
    private Integer preIndex;

    /**
     * 中间开始坐标
     */
    private Integer zhongIndex;

    /**
     * 后缀开始坐标
     */
    private Integer oldIndex;

    public int getResultLen() {
        return result.length();
    }
}
