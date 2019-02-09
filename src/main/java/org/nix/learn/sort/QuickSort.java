package org.nix.learn.sort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 快速排序
 * @date 2019/2/9
 */
public class QuickSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        runSort(0, nums.length - 1, nums);
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
            swap(num, tempStart, tempEnd);
        }
        swap(num, start, tempEnd);
        return tempEnd;
    }
}
