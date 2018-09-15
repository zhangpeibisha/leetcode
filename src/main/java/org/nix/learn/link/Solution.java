package org.nix.learn.link;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/8/23
 */
public class Solution {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * 4 -> 5 -> 1 -> 9
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int v = getLinkSize(head,0)-n;
        while (v-->0){
            head = head.next;
        }
        deleteNode(head);
        return head;
    }

    public int getLinkSize(ListNode head,int n){
        if (head.next!=null){
            return getLinkSize(head.next,++n);
        }
        return n;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * @param nums 给定一个数组
     */
    public void moveZeroes(int[] nums) {

    }




}
