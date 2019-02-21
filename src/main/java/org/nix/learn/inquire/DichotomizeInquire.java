package org.nix.learn.inquire;

/**
 * @author zhangpei
 * @version 1.0
 * @description 二分查询
 * @date 2019/2/14
 */
public class DichotomizeInquire implements Inquire {


    @Override
    public int inquire(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length - 1;
        while ((rigth - left) > 1) {
            int temp = (left + rigth) / 2;
            int num = nums[temp];
            if (num < target) {
                left = temp;
            } else if (num > target) {
                rigth = temp;
            } else {
                return temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DichotomizeInquire dichotomizeInquire = new DichotomizeInquire();
        int inquire = dichotomizeInquire.inquire(new int[]{1, 2, 5, 6, 7, 8}, 16);
        System.out.println(inquire);
    }
}
