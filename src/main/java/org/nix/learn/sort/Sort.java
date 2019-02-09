package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 排序算法实现
 * @date 2019/2/9
 */
public class Sort extends AbstactSort {
    /**
     * @param nums 待排序数组
     * @description 使用插入排序对一组数据排序
     * @author zhangpe0312@qq.com
     * @date 2019/2/9
     */
    public void insertSort(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return;
        }
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }


}
