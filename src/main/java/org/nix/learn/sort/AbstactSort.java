package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 排序公共方法
 * @date 2019/2/9
 */
public class AbstactSort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
