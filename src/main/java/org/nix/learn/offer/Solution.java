package org.nix.learn.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/8
 */
public class Solution {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}};
        System.out.println(Find(3, arr));
    }

    public static boolean Find(int target, int[][] array) {
        int len = array.length;

        if (array[0].length == 0 || array[0][0] > target) {
            return false;
        }
        if (array[0][len - 1] < target) {
            if (serch(target, array, len, len)) {
                return true;
            }
        }
        for (int i = 1; i < len; i++) {
            // 找到在第一排找到一个大于他的值，那么存在
            // 等于他的值就在i-1列中的
            if (array[0][i] > target) {
                if (serch(target, array, len, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean serch(int target, int[][] array, int len, int i) {
        for (int[] anArray : array) {
            if (anArray[i - 1] == target) {
                return true;
            }
            if (anArray[len - 1] > target) {
                for (int k = len - 1; k > 0; k--) {
                    if (anArray[k] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // -------------------------------------------------------

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    // -------------------------------------------------------

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
     */
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int len = list.size();
        ArrayList<Integer> returnV = new ArrayList<>(len);
        for (int i = len-1; i >= 0 ; i--) {
            returnV.add(list.get(i));
        }
        return returnV;
    }

    public ArrayList<Integer> printListFromTailToHeadTwo(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        int len = stack.size();
        ArrayList<Integer> va = new ArrayList<>(len);
        while (true){
            try {
                Integer value = stack.peek();
                if (value == null){
                    return va;
                }
                va.add(stack.pop());
            }catch (Exception e){
                return va;
            }
        }
    }

    // -------------------------------------------------------

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode rigth;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        return new TreeNode(1);
    }

    @Test
    public void reConstructBinaryTreeTest(){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
    }

}
