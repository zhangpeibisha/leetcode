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

        public ListNode() {
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
        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = deleteDuplication(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

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

    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int rigth = TreeDepth(root.right);
        return left > rigth ? left + 1 : rigth + 1;
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 创建一个头节点 p1记录没有重复的节点
        ListNode p1 = new ListNode();
        p1.next = null;
        ListNode head = p1;
        // p2用于跳过重复的节点
        ListNode p2 = pHead;
        while (p2 != null) {
            if (p2.next != null && p2.val == p2.next.val) {
                while (p2.next != null && p2.val == p2.next.val) {
                    p2 = p2.next;
                }
                // 跳过重复的最后个节点
                p2 = p2.next;
                //防止链表尾部出现重复值，p2==null跳出循环而p1没有跳过尾部重复
                p1.next = p2;
            } else {
                // 如果没有重复
                p1.next = p2;
                p1 = p2;
                p2 = p2.next;
            }
        }
        // 返回时去掉头节点
        return head.next;
    }

    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
     * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
     * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
     * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int sum = array[0];
        int tempsum = array[0];
        int len = array.length;
        for (int i = 1; i < len; i++) {
            tempsum = tempsum < 0 ? array[i] : tempsum + array[i];
            sum = tempsum > sum ? tempsum : sum;
        }
        return sum;
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        int tempNum2 = num2 > 0 ? num2 : -num2;
        for (int i = 0; i < tempNum2; i++) {
            if (num2 > 0) {
                num1++;
            } else {
                num1--;
            }
        }
        return num1;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 公式： 父节点 i 左节点 2*i+1 右节点 2*i+2
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode result = head;
        while (list1 != null && list2 != null) {
            int one = list1.val;
            int two = list2.val;
            if (one > two) {
                if (head == null) {
                    result = head = list2;
                } else {
                    head.next = list2;
                    head = head.next;
                }
                list2 = list2.next;
            } else {
                if (head == null) {
                    result = head = list1;
                } else {
                    head.next = list1;
                    head = head.next;
                }
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            head.next = list2;
        } else {
            head.next = list1;
        }
        return result;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        int len = sequence.length;
        Integer temp = sequence[0];
        for (int i = 1; i < len; i++) {
            if (temp > sequence[i]) {
                return false;
            } else {
                temp = sequence[i];
            }
        }
        return true;
    }

    public void maoPaoSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void maoPaoSort() {
        int[] arr = null;
        maoPaoSort(arr);
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * @param root 头节点
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {

        return null;
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
     * （时间复杂度应为O（1））。
     */
    class MyStack {

        Integer min;
        Stack<Integer> stack = new Stack<>();

        public void push(int node) {
            if (min == null) {
                min = node;
            } else if (min > node) {
                min = node;
            }
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }

    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null) {
            return null;
        }
        int len = input.length;
        ArrayList<Integer> result = new ArrayList<>(len);
        if (len < k) {
            for (int value : input) {
                result.add(value);
            }
            return result;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        int len = str.length();
        int[] chars = new int[52];
        char[] strCahr = str.toCharArray();
        for (char value : strCahr) {
            chars[index(value)]++;
        }
        // 寻找出value为1
        List<Integer> list = indexOne(chars);
        for (int i = 0; i < len; i++) {
            if (list.contains(index(strCahr[i]))) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * 找出数组中值为1的index
     *
     * @param value
     * @return
     */
    public static List<Integer> indexOne(int[] value) {
        int len = value.length;
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (value[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * @param c
     * @return
     */
    public static int index(char c) {
        if ((int) c >= 97 && (int) c <= 122) {
            return ((int) c) - 97 + 26;
        }
        if ((int) c >= 65 && (int) c <= 90) {
            return ((int) c) - 65;
        }
        return -1;
    }

    @Test
    public void tse() {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1}));
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     * 超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        int len = array.length;
        if (len == 1){
            return array[0];
        }
        Arrays.sort(array);
        int temp = 1;
        int air = len / 2 + 1;
        int pre = array[0];
        for (int i = 1; i < len; i++) {
            if (pre == array[i]) {
                temp++;
                if (exit(temp, air)) {
                    return pre;
                }
            } else {
                pre = array[i];
                temp = 1;
            }
        }
        return 0;
    }

    public static boolean exit(int temp, int air) {
        if (temp >= air) {
            return true;
        }
        return false;
    }

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        // 首先求得N是多少位数
        int nLength = length(n);

        return 0;
    }

    public static int length(int n){
        return 1;
    }

}
