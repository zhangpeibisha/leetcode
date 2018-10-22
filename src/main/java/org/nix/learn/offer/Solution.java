package org.nix.learn.offer;

import org.junit.jupiter.api.Test;
import sun.rmi.transport.tcp.TCPChannel;

import java.util.*;
import java.util.concurrent.*;

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
        for (int i = len - 1; i >= 0; i--) {
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
        while (true) {
            try {
                Integer value = stack.peek();
                if (value == null) {
                    return va;
                }
                va.add(stack.pop());
            } catch (Exception e) {
                return va;
            }
        }
    }

    // -------------------------------------------------------

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    @Test
    public void reConstructBinaryTreeTest() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
        System.out.println();
    }

    // -------------------------------------------------------

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        Integer integer = null;
        for (int value : array) {
            if (integer == null) {
                integer = value;
            } else {
                if (integer > value) {
                    return value;
                } else {
                    integer = value;
                }
            }
        }
        return 0;
    }

    @Test
    public void minNumberInRotateArray() {
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }

    // -------------------------------------------------------

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        List<Integer> integers = new ArrayList<>(stack2.size());
        while (!stack2.empty()) {
            integers.add(stack2.pop());
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        for (int i = integers.size() - 1; i >= 0; i--) {
            stack2.push(integers.get(i));
        }
        return stack2.pop();
    }

    @Test
    public void stackTest() {
        for (int i = 0; i < 20; i++) {
            push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(pop() + " ");
        }
        for (int i = 20; i < 40; i++) {
            push(i);
        }
        for (int i = 0; i < 30; i++) {
            System.out.print(pop() + " ");
        }
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }

        if (0 < n && n <= 2) {
            return 1;
        }

        int v1 = 0;
        int v2 = 1;

        for (int i = 2; i < n; i++) {
            int temp = v1 + v2;
            v1 = v2;
            v2 = temp;
        }
        return v2 + v1;
    }

    @Test
    public void fidbonacciTest() {
        System.out.println(fibonacci(6));
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * @param n
     * @return
     */
    public int jumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n <= 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int v1 = 1;
        int v2 = 2;

        for (int i = 3; i < n; i++) {
            int temp = v1 + v2;
            v1 = v2;
            v2 = temp;
        }
        return v2 + v1;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * <p>
     * 链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
     * 来源：牛客网
     * <p>
     * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
     * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
     * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
     * 所以f(n)=f(n-1)+f(n-2)+...+f(1)
     * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
     * 所以f(n)=2*f(n-1)
     *
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        long start = System.currentTimeMillis();
        int temp = n;
        int mi = 0;
        int bijiao;
        while (temp >= (bijiao = (int) Math.pow(2, mi))) {
            if (temp == bijiao) {
                return 1;
            }
            mi++;
        }
        mi--;
        int number = 0;
        while (temp != 0) {
            // 如果相减大于0说明符合要求
            int pow = (int) Math.pow(2, mi);
            if (temp - pow < 0) {
                mi--;
                continue;
            }
            temp = temp - pow;
            mi--;
            number++;
        }
        if (n < 0) {
            return ++number;
        }
        start = System.currentTimeMillis() - start;
        System.out.println(start);
        return number;
    }

    @Test
    public void numberOf1Test() {
        System.out.println(numberOf1(1000000000));
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }
        double temp = base;
        if (exponent > 0) {
            while (exponent > 1) {
                temp *= base;
                exponent--;
            }
        } else {
            while (exponent < 1) {
                temp /= base;
                exponent++;
            }
        }
        return temp;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        System.out.println(size);
        size = size - k;
        System.out.println(size);
        if (size < 0) {
            return null;
        }
        while (size > 0) {
            head = head.next;
            size--;
        }
        return head;
    }

    @Test
    public void FindKthToTailTest() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(myReverseList(node));
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode myReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    public void test() {
        int[] arr = {1,2,5,-7,8,-10};
        System.out.println(run(arr,0,-99999));
    }

    public int run(int[] arr, int start,int max) {
        int len = arr.length;
        int curr = 0;
        for (int i = start; i < len; i++) {
            int temp = curr + arr[i];
            if (temp >=  max) {
                curr += arr[i];
            }else {
              return run(arr,++start,curr);
            }
        }
        return curr;
    }
}
