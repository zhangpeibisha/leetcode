package org.nix.learn;

/**
 * @author zhangpei
 * @version 1.0
 * @description 自己写堆排序
 * @date 2019/2/12
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = {10, 7, 6, 3, 11, 12, 13, 5};
        heapSort.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public void sort(int[] nums) {
        initHeap(nums);
    }

    public void initHeap(int[] nums) {
        int length = nums.length;
        // 找到最后一个节点的位置开始调整，一次调整到top
        for (int i = (length - 2) / 2; i >= 0; i--) {
            abjectUp(i, length, nums);
        }
    }

    public void abjectUp(int k, int length, int[] nums) {
        // 记录目标调整值
        int temp = nums[k];
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
            if (i < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > temp) {
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = temp;
    }

}
