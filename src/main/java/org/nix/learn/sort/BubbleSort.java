package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 冒泡排序
 * @date 2019/2/9
 */
public class BubbleSort extends AbstractSort{

    @Override
    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length -1 ; i++) {
            // 判断是否发生了交换
            boolean flag = false;
            for (int k = 0; k < length - i - 1; k++) {
                if (nums[k] >= nums[k+1]){
                    swap(nums,k,k+1);
                    flag = true;
                }
            }
            // 如果没有发生交换则直接退出
            if (!flag){
                return;
            }
        }
    }
}
