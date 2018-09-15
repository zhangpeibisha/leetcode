package org.nix.learn.nums;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/8/18
 */
public class ExistenceRepetition {

    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.get(nums[i])!=null){
                return true;
            }
            map.put(nums[i],nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        ExistenceRepetition e = new ExistenceRepetition();
        Integer small = new Integer(123);
        e.change(e,small);
        System.out.println(e.i+" "+small);
    }
    public int i;
    public void change( ExistenceRepetition e,Integer b){
         int value = 0;

        e.i++;
        b++;
    }
}
