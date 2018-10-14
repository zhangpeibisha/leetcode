package org.nix.learn.tree;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/14
 */
public class TreeNode<T> {

    private TreeNode<T> left;

    private TreeNode<T> right;

    private T data;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
