package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 排序公共方法
 * @date 2019/2/9
 */
public abstract class AbstractSort implements Sort{
    /**
     * @param nums 交换数组
     * @param i 交换坐标i
     * @param j 交换坐标j
     * @description 数组交换数组
     * @author zhangpe0312@qq.com
     * @date 2019/2/9
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void run(int[] nums){
        if (nums == null){
            return;
        }
        sort(nums);
    }
}
