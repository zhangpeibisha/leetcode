package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/25
 */
public class Quick {

    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] num = {3, 2, 5, 1, 6, 5, 7, 4, 8};
        quick.runSort(0, num.length - 1, num);
//        System.out.println(quick.sort(0,num.length-1,num));
        for (int value : num) {
            System.out.print(value + " ");
        }
    }


    public void runSort(int start, int end, int[] num) {
        if (start >= end) {
            return;
        }
        int index = sort(start, end, num);
        runSort(start, index - 1, num);
        runSort(index + 1, end, num);
    }

    /**
     * 一轮划分
     *
     * @param start 开始坐标
     * @param end   结束坐标
     * @param num   排序数组
     */
    public int sort(int start, int end, int[] num) {
        int flag = num[start];
        int tempStart = start;
        int tempEnd = end + 1;

        while (true) {
            while (num[++tempStart] < flag) {
                if (tempStart >= end) {
                    break;
                }
            }
            while (num[--tempEnd] > flag) {
                if (tempEnd <= start) {
                    break;
                }
            }
            if (tempStart >= tempEnd) {
                break;
            }
            jiaohuan(tempStart, tempEnd, num);
        }
        jiaohuan(start, tempEnd, num);
        return tempEnd;
    }

    int temp = 0;

    /**
     * 交换两个坐标的值
     *
     * @param one
     * @param two
     * @param num
     */
    public void jiaohuan(int one, int two, int[] num) {
        int temp = num[one];
        num[one] = num[two];
        num[two] = temp;

        System.out.print(++temp + " 调用 one=" + one + " two=" + two + " | ");
        for (int value : num) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
