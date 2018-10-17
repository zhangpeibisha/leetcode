package org.nix.learn.sort;

import java.util.ArrayList;
import java.util.List;


/**
 * 优先队列
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/16
 */
public class MaxPQImpl implements MaxPQ<Integer> {

    private List<Integer> heap = new ArrayList<>();

    @Override
    public void insert(Integer integer) {
        heap.add(integer);
        int currindex = heap.size() - 1;
        int father;
        while (heap.get(father = (currindex - 1) / 2) < heap.get(currindex)) {
            int temp = heap.get(father);
            heap.set(father, heap.get(currindex));
            heap.set(currindex, temp);
            currindex = father;
        }
    }

    @Override
    public Integer max() {
        if (heap != null) {
            return heap.get(0);
        }
        return null;
    }

    @Override
    public Integer deleteMax() {
        int len = heap.size();
        int root = heap.get(0);
        int end = heap.get(len - 1);
        heap.set(0, end);
        heap.remove(len - 1);
        int currindex = 0;
        while (currindex < size()) {
            int left = currindex * 2 + 1;
            int right = currindex * 2 + 2;
            if (left >= size()) {
                break;
            }
            int max = left;
            if (right < size()) {
                if (heap.get(max) < heap.get(right)) {
                    max = right;
                }
            }
            if (heap.get(currindex) < heap.get(max)) {
                int temp = heap.get(currindex);
                heap.set(currindex, heap.get(max));
                heap.set(max, temp);
                currindex = max;
            } else {
                break;
            }
        }
        return root;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        heap.clear();
        int len = arr.length;
        for (int v : arr) {
            insert(v);
        }
        for (int i = 0; i < len; i++) {
            arr[i] = deleteMax();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 3, 5, 4, 10, 5, 23};
        MaxPQImpl maxPQ = new MaxPQImpl();
        maxPQ.sort(arr);
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
}
