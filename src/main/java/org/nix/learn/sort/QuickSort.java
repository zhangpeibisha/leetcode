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
        try {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            int sentinel = randomIndex(length);
            // 将哨兵放在第一位
            swap(nums, 0, sentinel);
            int i = groupingSort(nums);
            // 左边的数组
            sort(subArr(0, i, nums));
            // 右边的数组
            sort(subArr(i, length, nums));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private int groupingSort(int[] nums) {
        int start = 0;
        int end = nums.length;
        int length = nums.length;
        int sentinel = nums[start];
        int sentinelIndex = start;
        while (true) {
            // 如果哨兵大于该值，则不应该进行交换，所以此时检测不需要交换的值
            // 直到交换的值是出循环
            // 左边是哨兵大于则不需要交换
            while (++start < length - 1 && nums[start] < sentinel) {
                if (start >= end) {
                    break;
                }
            }
            // 如果哨兵小于等于该值，则不应该进行交换
            while (--end >= 0 && nums[end] > sentinel) {
                if (end <= start) {
                    break;
                }
            }
            if (start >= end) {
                // 最后将哨兵换到适合的位置
                swap(nums, sentinelIndex, end);
                return end;
            }
            swap(nums, start, end);
        }
    }

    /**
     * @param length 数组长度
     * @return int
     * @description 产生一个随机坐标，相对于数组长度
     * @author zhangpe0312@qq.com
     * @date 2019/2/9
     */
    private int randomIndex(int length) {
        if (length <= 0) {
            throw new IndexOutOfBoundsException("数组长度不能小于0:" + length);
        }
        return (int) (Math.random() * (length - 1));
    }

    /**
     * @param start 数组开始
     * @param end   数组结束
     * @param nums  母数组
     * @return int[]
     * @description 获取子数组
     * @author zhangpe0312@qq.com
     * @date 2019/2/9
     */
    private int[] subArr(int start, int end, int[] nums) {
        int len = end - start;
        int length = nums.length;
        if (len > length) {
            throw new IndexOutOfBoundsException("需要的子数组长度大于父数组长度" + len + ":" + length);
        }
        int[] sub = new int[len];
        int index = 0;
        for (int i = start; i < end; i++) {
            sub[index] = nums[i];
            index++;
        }
        return sub;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{6, 5, 42, 1, 45};
        int[] ints = quickSort.subArr(0, 2, nums);
        assertArrayEquals(new int[]{6, 5}, ints);
        ints = quickSort.subArr(3, 5, nums);
        assertArrayEquals(new int[]{1, 45}, ints);
        nums = new int[]{6, 5, 42, 1, 45, 5, 2, 54, 0, -1, 54, 6};
        int i = quickSort.groupingSort(nums);
        assertEquals(7, i);
        int[] ints1 = quickSort.subArr(0, i, nums);
        assertArrayEquals(new int[]{0, 5, 6, 1, -1, 5, 2}, ints1);
        int[] ints2 = quickSort.subArr(i, nums.length, nums);
        assertArrayEquals(new int[]{6, 54, 45, 54, 42}, ints2);

        i = quickSort.groupingSort(ints1);
        i = quickSort.groupingSort(ints2);
        System.out.println();
    }
}
