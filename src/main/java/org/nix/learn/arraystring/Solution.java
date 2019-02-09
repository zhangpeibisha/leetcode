package org.nix.learn.arraystring;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description leetCode数组与字符串练习题
 * https://leetcode-cn.com/explore/featured/card/tencent/221/array-and-strings/894/
 * @date 2019/2/8
 */
public class Solution {

    /**
     * @param nums   给定一个整数数组 nums
     * @param target 一个目标值 target
     * @return int[]
     * @description 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @author zhangpe0312@qq.com
     * @date 2019/2/8
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            temp = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (target - temp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * @param nums1 nums1
     * @param nums2 nums2
     * @return double
     * @description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * @author zhangpe0312@qq.com
     * @date 2019/2/8
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. 假设存在i和j 有 num1[i] <= nums[j] 则 num1[1...i] <= num2[j]
        // 2. 又nums2[1...j] <= num2[j]
        // 3. 因此在整体的组合数组中 num2[j] 肯定大于 整合数组中 i+j之前的值
        // 4. 需要找到第K小的值则得到需要的值
        // 5. 因此每一次都寻找到第k小的值，直到k=1时得到结果

        return 0;
    }

}
