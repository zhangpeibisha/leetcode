package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 选择排序
 * @date 2019/2/9
 */
public class ChooseSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (nums[j] < nums[i]){
                    swap(nums,i,j);
                }
            }
        }
    }
}
