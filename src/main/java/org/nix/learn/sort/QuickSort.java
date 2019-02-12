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
        // 获取到新一轮的哨兵
        int index = sort(start, end, num);
        // 左边
        runSort(start, index - 1, num);
        // 右边
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
        // 哨兵数据
        int flag = num[start];
        // 方法体中计算的局部变量
        // 用于计算扫描的左指针和又指针的位置，当左指针位置大于又指针的时候，则退出循环
        int tempStart = start;
        int tempEnd = end + 1;
        while (true) {
            // 当哨兵大于左指针的数据时不做处理
            // 只有当左指针大于哨兵的时候退出并记录当前指针用于后续交换数据
            // 适用于升序排序
            while (num[++tempStart] < flag) {
                if (tempStart >= end) {
                    break;
                }
            }
            // 和左指针差不多的道理
            while (num[--tempEnd] > flag) {
                if (tempEnd <= start) {
                    break;
                }
            }
            // 如果左指针大于右指针说明此轮交换结束
            if (tempStart >= tempEnd) {
                break;
            }
            // 交换位置
            swap(num, tempStart, tempEnd);
        }
        // 将哨兵放在合适的位置
        swap(num, start, tempEnd);
        return tempEnd;
    }
}
