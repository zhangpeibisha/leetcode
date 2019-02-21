package org.nix.learn.inquire;

/**
 * @author zhangpei
 * @version 1.0
 * @description 查询接口
 * @date 2019/2/14
 */
public interface Inquire {

    /**
     * @param nums 待查询数组
     * @param target 目标查询值
     * @return int 返回查询值的位置
     * @description 查询一个值在数组中的哪个位置，如果没有返回-1
     * @author zhangpe0312@qq.com
     * @date 2019/2/14
     */
    int inquire(int[] nums, int target);

}
