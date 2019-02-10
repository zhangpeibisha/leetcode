package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @description 堆排序
 * 堆排序：（大根堆）
 * <p>
 * ①将存放在array[0，...，n-1]中的n个元素建成初始堆；
 * <p>
 * ②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；
 * <p>
 * ③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。
 * <p>
 * 堆排序算法的性能分析：
 * <p>
 * 空间复杂度:o(1)；
 * <p>
 * 时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
 * <p>
 * 稳定性：不稳定
 * <p>
 * 父节点：i==0 ? null : (i-1)/2
 * 左孩子：2*i + 1
 * 右孩子：2*i + 2
 * @date 2019/2/10
 */
public class HeapSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        initHeap(nums);
        int length = nums.length;
        for (int i = length - 1; i > 1; i--) {
            swap(nums, 0, i);
            adjustDownToUp(nums, 0, i);
        }
    }

    /**
     * @param nums 北条政数组
     * @description 初始化最大堆
     * @author zhangpe0312@qq.com
     * @date 2019/2/10
     */
    public void initHeap(int[] nums) {
        int length = nums.length;
        // 首先定位到最后一个父节点，然后依次调整
        for (int i = (length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(nums, i, length);
        }
    }

    /**
     * @param nums 数组
     * @param k    需要调整的节点,这是一个父节点
     * @description 自下而上的调整堆
     * @author zhangpe0312@qq.com
     * @date 2019/2/10
     */
    private void adjustDownToUp(int[] nums, int k, int length) {
        // 父节点值
        int temp = nums[k];
        // 从左孩子开始比较，比较步长为下一个左孩子，也就是左孩子的左孩子
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
            // 1. 左孩子存在 2. 左孩子小于右孩子，则坐标记录为右孩子的值
            if (i < length && nums[i] < nums[i + 1]) {
                i++;
            }
            // 如果当前父节点小于其中的最大值
            if (temp < nums[i]) {
                // 将左右子结点中较大值array[i]调整到双亲节点上
                nums[k] = nums[i];
                // 更新父节点,为后续调准赋值
                k = i;
            }
        }
        //被调整的结点的值放人最终位置
        nums[k] = temp;
    }

    /**
     * @param nums 待插入数组
     * @param data 插入数据
     * @description 首先将数据放到数组尾部，如果然后获取尾部数据的父节点然后通过比较进行上浮
     * @author zhangpe0312@qq.com
     * @date 2019/2/10
     */
    public void insertDataToHeap(int[] nums, int data) {
        int length = nums.length;
        insertDataToArr(nums, data);
        //需要调整的节点
        int k = length - 1;
        // 双亲节点
        int parent = (k - 1) / 2;
        while (parent >= 0 && data > nums[parent]) {
            //双亲节点下调
            nums[k] = nums[parent];
            k = parent;
            if (parent != 0) {
                //继续向上比较
                parent = (parent - 1) / 2;
            } else {
                //根节点已调整完毕，跳出循环
                break;
            }
        }
        nums[k] = data;
    }

    private void insertDataToArr(int[] nums, int data) {
        int length = nums.length;
        if (nums[length - 1] == 0) {
            nums[length - 1] = data;
        } else {
            int[] temp = nums;
            int newLen = length + 1;
            nums = new int[newLen];
            for (int i = 0; i < length; i++) {
                nums[i] = temp[i];
            }
            nums[length] = data;
        }
    }

    /**
     * @param nums
     * @return int[]
     * @description 删除堆顶元素操作
     * @author zhangpe0312@qq.com
     * @date 2019/2/10
     */
    public void deleteMax(int[] nums) {
        //将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = -99999;
        //对此时的根节点进行向下调整
        adjustDownToUp(nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[2];
        nums[0] = 1;
        System.out.println(nums[1]);
    }
}
