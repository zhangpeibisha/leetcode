package org.nix.learn.set;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

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
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = len1 > len2 ? len1 : len2;
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
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
     * <p>
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为
     * 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        return isHappy(n,new ArrayList<Integer>());
    }

    public boolean isHappy(int n, List<Integer> temp){
        if (n==1){
            return true;
        }
        int v = he(chaiStr(n));
        if (temp.contains(v)){
            return false;
        }
        temp.add(v);
        return isHappy(v,temp);
    }

    public int he(int[] value){
        int temp = 0;
        for (int v : value) {
            temp += v*v;
        }
        return temp;
    }

    public int[] chai(int n) {
        List<Integer> save = new ArrayList<>(11);
        chai(n, 10, save);
        int len = save.size();
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = save.get(i);
        }
        return temp;
    }

    public void chai(int n, int v, List<Integer> save) {
        int temp1 = n % v;
        int temp2 = temp1 / (v / 10);
        System.out.println(temp1 + "%"+v+"  "+temp2);
        save.add(temp2);
        if (n / v == 0) {
            return;
        }
        chai(n, v * 10, save);
    }

    public int[] chaiStr(Integer n){
        char[] toc = n.toString().toCharArray();
        int[] result = new int[toc.length];
        int i = 0;
        for (char v : toc) {
            result[i] = (int)v-48;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 121654212;
        Integer ia = a;
        System.out.println(ia.toString());

    }
}
