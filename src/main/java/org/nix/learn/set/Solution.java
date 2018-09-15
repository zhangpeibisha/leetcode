package org.nix.learn.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/15
 */
public class Solution {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = len1>len2?len1:len2;
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j <len2 ; j++) {
                if (nums1[i]==nums2[j]){
                    temp.add(nums1[i]);
                }
            }
        }
        int[] ret = new int[temp.size()];
        int index = 0;
        for (Integer va : temp) {
            ret[index] = va;
            index++;
        }
        return ret;
    }

    /**
     * 编写一个算法来判断一个数是不是“快乐数”。
     *
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为
     * 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n==1){
           return true;
        }
        return false;
    }

    public int[] chai(int n){
        return null;
    }
}
