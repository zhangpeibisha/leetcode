package org.nix.learn.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/14
 */
public class BinaryTree<T> {

    private TreeNode<T> root;

    public void createTreeByArr(T[] arr) {
        if (root == null) {
            root = new TreeNode<>();
        }
        createTreeByArr(root, arr, 0);
    }

    /**
     * 右孩子节点的个数：Math.pow(2,Math.log((len = arr.length+1))/Math.log(2))-1
     * Math.log((len = arr.length+1))/Math.log(2)  代表二叉树有多少层  2^k-1 = (len = arr.length)
     * Math.pow(2,Math.log((len = arr.length+1))/Math.log(2))-1  通过等比求和算出应该有几个含有儿子节点的双亲节点
     * 等比求和公式（2^0 + 2^1 + 2^2 = (1-2^2)*2^0/(1-2)）
     * @param root
     * @param arr
     * @param index
     */
    private void createTreeByArr(TreeNode<T> root, T[] arr, int index) {
        int len;
        if (root == null || arr == null || Math.pow(2,Math.log((len = arr.length+1))/Math.log(2))-1 <= index || index < 0) {
            return;
        }
        if (index == 0) {
            root.setData(arr[0]);
        }
        // 左孩子
        int currIndex = index * 2 + 1;
        T temp;
        if (currIndex < len - 1 && (temp = arr[currIndex]) != null) {
            root.setLeft(new TreeNode<>(temp));
        }
        // 右孩子
        currIndex = index * 2 + 2;
        if (currIndex < len - 1 && (temp = arr[currIndex]) != null) {
            root.setRight(new TreeNode<>(temp));
        }

        createTreeByArr(root.getLeft(), arr, index*2 + 1);
        createTreeByArr(root.getRight(), arr, index*2 + 2);
    }

    @Test
    public void createTreeByArrTest() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.createTreeByArr(data);
        System.out.println();
        tree.DLR(tree.root);
        System.out.println();
        tree.LDR(tree.root);
    }

    /**
     * 递归先序遍历
     *
     * @param root
     */
    public void DLR(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        DLR(root.getLeft());
        DLR(root.getRight());
    }

    /**
     * 递归中序遍历
     *
     * @param root
     */
    public void LDR(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        LDR(root.getLeft());
        System.out.print(root.getData() + " ");
        LDR(root.getRight());
    }

}
